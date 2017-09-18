package com.epam.courses.jf.se10.stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StAXWriteXMLExample {

    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();

        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("tmp.xml"));

        writer.writeStartDocument();

        writer.writeStartElement("root");
        writer.writeDefaultNamespace("abc.ru/wqewqe");
        writer.writeCData("blabla");
        writer.writeEndElement();

        writer.writeEndDocument();
        writer.close();
    }
}
