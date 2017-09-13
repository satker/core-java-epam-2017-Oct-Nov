package com.epam.courses.jf.se8.pools.fourth;

import java.util.ResourceBundle;

public class DBPropertiesParams implements DBParams {

    private static final int DEFAULT_POOL_SIZE = 10;
    private final String driver;
    private final String url;
    private final String user;
    private final String password;
    private final int poolSize;

    public DBPropertiesParams(String propertiesFile) {
        ResourceBundle bundle = ResourceBundle.getBundle(propertiesFile);
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        password = bundle.getString("password");
        poolSize = parseNumberConnections(bundle.getString("pool.size"));
    }

    private static int parseNumberConnections(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            return DEFAULT_POOL_SIZE;
        }
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String getURL() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int getPoolSize() {
        return poolSize;
    }
}
