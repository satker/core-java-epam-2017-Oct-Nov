package com.epam.courses.jf.se8.dao.impl.file;

import com.epam.courses.jf.se8.dao.interfaces.DAODepartments;
import com.epam.courses.jf.se8.dao.interfaces.DAOFactory;
import com.epam.courses.jf.se8.dao.interfaces.DAOGroups;
import com.epam.courses.jf.se8.dao.interfaces.DAOStudents;

public class XMLDAOFactory implements DAOFactory {

    @Override
    public DAOGroups getDaoGroups() {
        return new XMLDAOGroups();
    }

    @Override
    public DAOStudents getDaoStudents() {
        return new XMLDAOStudents();
    }

    @Override
    public DAODepartments getDaoDepartments() {
        return new XMLDAODepartments();
    }
}
