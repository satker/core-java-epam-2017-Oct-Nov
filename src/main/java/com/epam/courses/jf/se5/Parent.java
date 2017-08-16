package com.epam.courses.jf.se5;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Parent {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Parent parent = new Child();
        try {
            parent.checkedExceptionsMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Child child = new Child();
    }

    public Parent() throws IllegalAccessException {
    }

    public void checkedExceptionsMethod() throws IOException {
        throw new IOException();
    }

    public void uncheckedExceptionsMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }
}

class Child extends Parent {

    public Child() throws IllegalAccessException, ClassNotFoundException {
        super();
    }

    @Override
    public void checkedExceptionsMethod() throws NullPointerException, FileNotFoundException {
        try {
            super.checkedExceptionsMethod();
        } catch (IOException e) {
            e.printStackTrace();
            throw (FileNotFoundException)e;
        }
    }

    @Override
    public void uncheckedExceptionsMethod() {
        System.out.println();
    }
}
