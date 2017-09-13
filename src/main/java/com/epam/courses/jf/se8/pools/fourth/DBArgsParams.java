package com.epam.courses.jf.se8.pools.fourth;

public class DBArgsParams implements DBParams {

    private final String[] params;

    public DBArgsParams(String[] params) {
        this.params = params;
    }

    @Override
    public String getDriver() {
        return params[0];
    }

    @Override
    public String getURL() {
        return params[1];
    }

    @Override
    public String getUser() {
        return params[2];
    }

    @Override
    public String getPassword() {
        return params[3];
    }

    @Override
    public int getPoolSize() {
        return Integer.parseInt(params[4]);
    }
}
