package com.epam.courses.jf.se10.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JDOMChanger {

    static void lookForElement(String filename, String element, String content,	String login) {
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(filename);
            Element root = document.getRootElement();
            List c = root.getChildren();

            for (Object aC : c) {
                Element e = (Element) aC;
                if (e.getAttributeValue("login").equals(login)) {
                    e.getChild(element).setText(content);
                }
            }
            XMLOutputter serializer = new XMLOutputter();
            try (FileOutputStream stream = new FileOutputStream(filename)) {
                serializer.output(document, stream);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи XML-файла" + e);
        } catch (JDOMException e) {
            System.err.println("Ошибка при разборе доку-мента" + e);
        }
    }
    public static void main(String[] args) {
        String filename = "C:\\Users\\Nikolai_Plokhoi\\IdeaProjects\\epam-summer-2017\\src\\main\\resources\\com\\epam\\courses\\jf\\se10\\students.xml";
        JDOMChanger.lookForElement(filename, "telephone", "09", "mit");
        System.out.println("Изменение произведено успешно.");
    }
}

