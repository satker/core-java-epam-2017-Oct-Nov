package com.epam.courses.jf.se10.sax;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SimpleSAXMain {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(false);
        SAXParser sp = spf.newSAXParser();
        sp.parse(new File("C:\\Users\\Nikolai_Plokhoi\\IdeaProjects\\epam-summer-2017\\src\\main\\resources\\com\\epam\\courses\\jf\\se10\\web.xml"), new SimpleSAXExample());
    }
}

