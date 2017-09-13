package com.epam.courses.jf.se8.dao.impl.hsqldb;

import com.epam.courses.jf.se8.dao.interfaces.DAODepartments;
import com.epam.courses.jf.se8.dao.interfaces.DAOFactory;
import com.epam.courses.jf.se8.dao.interfaces.DAOGroups;
import com.epam.courses.jf.se8.dao.interfaces.DAOStudents;

public class HsqldbDAOFactory implements DAOFactory {

    @Override
    public DAOGroups getDaoGroups() {
        return new HsqldbDAOGroups();
    }

    @Override
    public DAOStudents getDaoStudents() {
        return new HsqldbDAOStudents();
    }

    @Override
    public DAODepartments getDaoDepartments() {
        return new HsqldbDAODepartments();
    }
}
