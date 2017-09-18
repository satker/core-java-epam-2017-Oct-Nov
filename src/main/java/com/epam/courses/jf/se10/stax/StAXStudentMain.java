package com.epam.courses.jf.se10.stax;

import java.io.FileInputStream;
import java.io.InputStream;

public class StAXStudentMain {
    public static void main(String[] args) throws Exception {
        StAXStudentsParser parser = new StAXStudentsParser();
        // создание входного потока данных из xml-файла
        InputStream input = new FileInputStream("C:\\Users\\Nikolai_Plokhoi\\IdeaProjects\\epam-summer-2017\\src\\main\\resources\\com\\epam\\courses\\jf\\se10\\students.xml");
        // разбор файла с выводом результата на консоль
        parser.parse(input);
    }
}

