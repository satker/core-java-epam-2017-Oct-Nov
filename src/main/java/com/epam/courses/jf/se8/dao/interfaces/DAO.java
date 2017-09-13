package com.epam.courses.jf.se8.dao.interfaces;

import java.util.Collection;

public interface DAO <T> {

    void add(T value);
    Collection<T> getAll();
    void update(T value);
    boolean remove(T value);
}
