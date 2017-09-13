package com.epam.courses.jf.se8.pools.fourth;

public interface DBParams {

    String getDriver();
    String getURL();
    String getUser();
    String getPassword();
    int getPoolSize();
}
