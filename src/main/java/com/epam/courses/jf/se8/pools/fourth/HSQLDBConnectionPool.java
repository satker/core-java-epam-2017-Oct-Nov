package com.epam.courses.jf.se8.pools.fourth;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Singleton
public class HSQLDBConnectionPool {

    private static final int DEFAULT_POOL_SIZE = 10;
    private static HSQLDBConnectionPool instance;
    private final BlockingQueue<Connection> connectionQueue;

    @Inject
    private HSQLDBConnectionPool(@Named("HSQLDBParams")DBParams params) throws ClassNotFoundException, SQLException {
        Class.forName(params.getDriver());
        connectionQueue = new ArrayBlockingQueue<>(params.getPoolSize());
        for (int i = 0; i < params.getPoolSize(); i++) {
            connectionQueue.offer(DriverManager.getConnection(params.getURL(), params.getUser(), params.getPassword()));
        }
    }

    private static int parseNumberConnections(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            return DEFAULT_POOL_SIZE;
        }
    }

    public static HSQLDBConnectionPool getInstance() {
        return instance;
    }

    public static void dispose() throws SQLException {
        if (instance != null) {
            instance.clearConnectionQueue();
            instance = null;
            //"Connection pool succesfully disposed"
        }
    }

    public Connection takeConnection() {
        try {
            return connectionQueue.poll(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection connection) {
        try {
            if (!connection.isClosed()) {
                if (!connectionQueue.offer(connection)) {
                    //"Connection not added. Possible `leakage` of
                    // connections"
                }
            } else {
                //"Trying to release closed connection. Possible
                // `leakage` of connections"
            }
        } catch (SQLException e) {
            //"SQLException at conection isClosed () checking.
            // Connection not added", e
        }
    }

    private void clearConnectionQueue() throws SQLException {
        Connection connection;
        while ((connection = connectionQueue.poll()) != null) {
            /* see java.sql.Connection#close () javadoc */
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.close();
        }
    }
}
