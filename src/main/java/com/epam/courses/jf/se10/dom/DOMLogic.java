package com.epam.courses.jf.se10.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class DOMLogic {

    public static void main(String[] args) {
        try {
            // создание DOM-анализатора(JSDK)
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            // распознавание XML-документа
            Document document = db.parse("C:\\Users\\Nikolai_Plokhoi\\IdeaProjects\\epam-summer-2017\\src\\main\\resources\\com\\epam\\courses\\jf\\se10\\students.xml");
            // создание DOM-анализатора (Xerces)
	/*
	 * DOMParser parser = new DOMParser(); parser.parse("students.xml");
	 * Document document = parser.getDocument();
	 */

            Element root = document.getDocumentElement();
            ArrayList<Student> students = Analyzer.listBuilder(root);
            students.forEach(System.out::println);
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.print("ошибка SAX парсера");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.print("ошибка конфигурации");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("ошибка I/О потока");
        }
    }
}

