package com.epam.courses.jf.se5;

import java.io.*;

public class TryWithResources {

    public static void main(String[] args) {

        try (InputStream input = new FileInputStream("1.txt");
             OutputStream output = new FileOutputStream("123.txt")) {
            input.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
