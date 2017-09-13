package com.epam.courses.jf.se5;

import java.io.FileNotFoundException;

public class NewException {

    public static void main(String[] args) {

    }

    public static void method() throws FileNotFoundException {
        try {
            if (true) {
                throw new FileNotFoundException();
            }



        } catch (Exception ex) {
            System.out.println("");
            throw ex;
        }

    }
}


