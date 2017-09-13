package com.epam.courses.jf.se8.dao.interfaces;

import com.epam.courses.jf.se8.model.Student;

public interface DAOStudents extends DAO<Student> {

    Student getById(int id);
}
