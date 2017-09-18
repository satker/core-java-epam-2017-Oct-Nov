package com.epam.courses.jf.se10.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXStudentsParser {

    public void parse(InputStream input) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    // метод, управляющий разбором потока
    private void process(XMLStreamReader reader) throws XMLStreamException {
        String name;
        while (reader.hasNext()) {
            // определение типа "прочтённого" элемента (тега)
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName().toUpperCase();
                    writeStudentFeature(name);
                    ElementsName enumName = ElementsName.valueOf(name);
                    studentInfoHandle(enumName, reader);
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    break;

                case XMLStreamConstants.CHARACTERS:
                    writeText(reader.getText());
                    break;

            }
        }
    }

    private void studentInfoHandle(ElementsName enumName, XMLStreamReader reader) {
        switch (enumName) {
            case STUDENTS:
                writeTitle();
                break;

            case STUDENT:
                String login = reader.getAttributeValue(null, ElementsName.LOGIN.name().toLowerCase());
                String faculty = reader.getAttributeValue(null, ElementsName.FACULTY.name().toLowerCase());
                writeStudent(login, faculty);
                break;

            case ADDRESS:
                writeAddress();
                break;
        }
    }

    public void writeTitle() {
        System.out.println("Students:");
    }

    public void writeStudent(String... args) {
        System.out.println("Student: Login: " + args[0] + " Faculty: " + args[1]);
    }

    public void writeAddress() {
        System.out.println(" Address: ");
    }

    public void writeStudentFeature(String name) {
        switch (ElementsName.valueOf(name)) {
            case STREET:
                System.out.print(" Street: ");
                break;
            case CITY:
                System.out.print(" City: ");
                break;
            case COUNTRY:
                System.out.print("Country: ");
                break;
            case TELEPHONE:
                System.out.print(" Telephone: ");
                break;
            case NAME:
                System.out.print("Name: ");
                break;
        }
    }

    public void writeText(String text) {
        System.out.println(text.trim());
    }
}

enum ElementsName {
    STUDENTS,
    STUDENT,
    ADDRESS,
    STREET,
    CITY,
    COUNTRY,
    TELEPHONE,
    NAME,
    FACULTY,
    LOGIN
}