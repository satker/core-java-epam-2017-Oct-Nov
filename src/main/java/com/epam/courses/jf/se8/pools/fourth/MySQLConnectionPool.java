package com.epam.courses.jf.se8.pools.fourth;

import com.google.inject.*;
import com.google.inject.name.Named;

@com.google.inject.Singleton
public class MySQLConnectionPool {

    @Inject
    public MySQLConnectionPool(@Named("MySQLDBParams") DBParams params) {
    }
}
