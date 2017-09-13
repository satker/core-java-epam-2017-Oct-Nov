package com.epam.courses.jf.se8.pools.fourth;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Launcher {

    public static void main(String[] args) {
        DBParams hsqldbParams = args.length == 0 ? new DBPropertiesParams("db.properties")
                                                 : new DBArgsParams(args);

        DBParams mysqlParams = args.length == 0 ? new DBPropertiesParams("db.properties")
                                                : new DBArgsParams(args);

        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(DBParams.class).annotatedWith(Names.named("HSQLDBParams")).toInstance(hsqldbParams);
                bind(DBParams.class).annotatedWith(Names.named("MySQLDBParams")).toInstance(mysqlParams);
                bind(HSQLDBConnectionPool.class);

            }
        });

        AnotherClass object = injector.getInstance(AnotherClass.class);

        HSQLDBConnectionPool pool = injector.getInstance(HSQLDBConnectionPool.class);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                Connection connection = null;
                try {
                    connection = pool.takeConnection();

                    if (connection == null) {
                        System.out.println("Can't take connection :C");
                        return;
                    }

                    System.out.println(connection.isClosed());
                    TimeUnit.SECONDS.sleep(10);
                } catch (SQLException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        pool.releaseConnection(connection);
                    }
                }
            }).start();
        }

    }
}
