package com.epam.courses.jf.se8.dao;

import com.epam.courses.jf.se8.dao.interfaces.DAOFactory;
import com.epam.courses.jf.se8.dao.interfaces.DAOStudents;
import com.epam.courses.jf.se8.model.Student;
import com.google.inject.Inject;

public class StudentsProcessor {

    private final DAOStudents dao;

    @Inject
    public StudentsProcessor(DAOFactory factory) {
        this.dao = factory.getDaoStudents();
    }

    public void process() {
        Student student = dao.getById(1);
        System.out.println(student);

        student.setName("123");
        dao.update(student);
    }
}
