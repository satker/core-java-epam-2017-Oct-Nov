package com.epam.courses.jf.se8.pools.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {

    private static ConnectionPool instance;
    private final ArrayList<Connection> freeConnections = new ArrayList<>();
    private final String driverName;
    private final String URL;
    private final String user;
    private final String password;
    private final int maxConn;

    private ConnectionPool(String driverName, String URL, String user, String password, int maxConn) {
        this.driverName = driverName;
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.maxConn = maxConn;
        loadDrivers();
    }

    private void loadDrivers() {
        try {
            Class.forName(driverName);
        } catch (Exception e) {
            // "Can't register JDBC driver "
        }
    }

    static synchronized public ConnectionPool getInstance(String driverName, String URL, String user, String password, int maxConn) {
        if (instance == null) {
            instance = new ConnectionPool(driverName, URL, user, password, maxConn);
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        Connection con;
        if (!freeConnections.isEmpty()) {
            con = freeConnections.get(freeConnections.size() - 1);
            freeConnections.remove(con);
            try {
                if (con.isClosed()) {
                    con = getConnection();
                }
            } catch (Exception e) {
                con = getConnection();
            }
        } else {
            con = newConnection();
        }
        return con;
    }

    private Connection newConnection() {
        try {
            return user == null ? DriverManager.getConnection(URL)
                                : DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            // "Can't create a new connection for " + URL
            return null;
        }
    }

    public synchronized void freeConnection(Connection con) {
        if (con != null) {
            try {
                if (!con.isClosed() && freeConnections.size() < maxConn) {
                    freeConnections.add(con);
                } else {
                    con.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public synchronized void release() {
        for (Connection con : freeConnections) {
            try {
                con.close();
                // "Closed connection for pool „
            } catch (SQLException e) {
                // "Can't close connection for pool „
            }
        }
        freeConnections.clear();
    }
}
