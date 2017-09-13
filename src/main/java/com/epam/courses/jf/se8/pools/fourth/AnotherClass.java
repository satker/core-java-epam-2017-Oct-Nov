package com.epam.courses.jf.se8.pools.fourth;

import com.google.inject.Inject;

public class AnotherClass {

    private final HSQLDBConnectionPool pool;

    @Inject
    public AnotherClass(HSQLDBConnectionPool pool) {
        this.pool = pool;
    }
}
