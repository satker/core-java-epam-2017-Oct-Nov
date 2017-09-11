package com.epam.courses.jf.se8.pools.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    public static final String PROPERTIES_FILE = "properties/database";
    public static final int DEFAULT_POOL_SIZE = 10;
    private static ConnectionPool instance;
    private BlockingQueue<Connection> connectionQueue;

    public static void init() throws SQLException {
        if (instance == null) {
            ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE);
            String driver = rb.getString("db.driver");
            String url = rb.getString("db.url");
            String user = rb.getString("db.user");
            String password = rb.getString("db.password");
            int poolSize = parseNumberConnections(rb.getString("db.poolsize"));
            try {
                instance = new ConnectionPool(driver, url, user, password, poolSize);
            } catch (ClassNotFoundException e) {
                //"Driver " + driver + " not found"
                throw new RuntimeException(e);
            }
        }
    }

    private static int parseNumberConnections(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            return DEFAULT_POOL_SIZE;
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public static void dispose() throws SQLException {
        if (instance != null) {
            instance.clearConnectionQueue();
            instance = null;
            //"Connection pool succesfully disposed"
        }
    }

    private ConnectionPool(String driver, String url, String user, String password, int poolSize) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connectionQueue = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            connectionQueue.offer(DriverManager.getConnection(url, user, password));
        }
    }

    public Connection takeConnection() {
        try {
            return connectionQueue.take();
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
