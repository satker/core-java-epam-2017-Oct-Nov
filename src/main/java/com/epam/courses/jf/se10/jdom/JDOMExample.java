package com.epam.courses.jf.se10.jdom;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;

public class JDOMExample {

    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File("C:\\Users\\Nikolai_Plokhoi\\IdeaProjects\\epam-summer-2017\\src\\main\\resources\\com\\epam\\courses\\jf\\se10\\web.xml"));
        document.getRootElement()
                .getChildren("servlet")
                .stream()
                .filter(element -> element.getAttributes().isEmpty())
                .forEach(element -> System.out.println(element.getChild("servlet-name").getValue() + ": " + element.getChild("servlet-class").getValue()));
    }
}
