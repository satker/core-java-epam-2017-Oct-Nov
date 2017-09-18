package com.epam.courses.jf.se10.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MarshalMain {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller m = context.createMarshaller();


            Student.Address addr = new Student.Address("BLR", "Minsk", "Skoriny 4");
            Student student = new Student("mendig", "Dmitry Terenya", "rfe", 2066394, addr);

            List<Student> students = new ArrayList<>();
            students.add(student);
            students.add(student);

            m.marshal(students, new FileOutputStream("stud.xml"));
            m.marshal(students, System.out);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Student stud = (Student) unmarshaller.unmarshal(new FileInputStream("stud.xml"));
            System.out.println("Unmarshalled:");
            System.out.println(stud);


            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не найден");
            e.printStackTrace();
        } catch (JAXBException e) {
            System.out.println("JAXB-исключения");
            e.printStackTrace();
        }
    }
}

