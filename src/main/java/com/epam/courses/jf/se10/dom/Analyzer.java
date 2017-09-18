package com.epam.courses.jf.se10.dom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

public class Analyzer {

    public static ArrayList<Student> listBuilder(Element root) throws SAXException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        // получение списка дочерних элементов <student>
        NodeList studentsNodes = root.getElementsByTagName("student");
        for (int i = 0; i < studentsNodes.getLength(); i++) {
            Student student = new Student();
            Element studentElement = (Element) studentsNodes.item(i);
            // заполнение объекта student

            student.setFaculty(studentElement.getAttribute("faculty"));
            student.setLogin(studentElement.getAttribute("login"));
            student.setName(getChildValue(studentElement, "name"));
            student.setTelephone(Integer.valueOf(getChildValue(studentElement, "telephone")));
            Student.Address address = student.getAddress();
            // заполнение объекта address
            Element addressElement = getChild(studentElement, "address");
            address.setCountry(getChildValue(addressElement, "country"));
            address.setCity(getChildValue(addressElement, "city"));
            address.setStreet(getChildValue(addressElement, "street"));
            students.add(student);
        }// конец цикла for
        return students;
    }

    // возвращает дочерний элемент по его имени и родительскому элементу
    private static Element getChild(Element parent, String childName) {
        NodeList nlist = parent.getElementsByTagName(childName);
        return (Element) nlist.item(0);
    }

    // возвращает текст, содержащийся в элементе
    private static String getChildValue(Element parent, String childName) {
        Element child = getChild(parent, childName);
        Node node = child.getFirstChild();
        return node.getNodeValue();
    }
}

