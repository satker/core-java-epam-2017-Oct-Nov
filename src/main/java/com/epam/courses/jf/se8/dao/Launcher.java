package com.epam.courses.jf.se8.dao;

import com.epam.courses.jf.se8.dao.impl.hsqldb.HsqldbDAOFactory;
import com.epam.courses.jf.se8.dao.interfaces.DAOFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Launcher {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(DAOFactory.class).to(HsqldbDAOFactory.class);
            }
        });

        StudentsProcessor studentsProcessor = injector.getInstance(StudentsProcessor.class);
    }
}
