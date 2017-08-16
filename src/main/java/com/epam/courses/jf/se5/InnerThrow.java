package com.epam.courses.jf.se5;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InnerThrow {


    public static void main(String[] args) throws FileNotFoundException {
        try {
            try {
                throw new FileNotFoundException("123");
            } catch (FileNotFoundException e) {
                System.out.println("File");
                throw e;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            System.out.println("IO");
            ex.printStackTrace();
        }
    }
}
