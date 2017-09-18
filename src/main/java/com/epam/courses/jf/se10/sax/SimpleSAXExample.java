package com.epam.courses.jf.se10.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class SimpleSAXExample extends DefaultHandler {

    StringBuffer accumulator = new StringBuffer();
    String servletName;
    String servletClass;
    String servletId;

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        accumulator.setLength(0);
        if ("servlet".equals(qName)) {
            servletId = attributes.getValue("id");
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        accumulator.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "servlet-name":
                servletName = accumulator.toString().trim();
                break;
            case "servlet-class":
                servletClass = accumulator.toString().trim();
                break;
            case "servlet":
                System.out.printf("Servlet %s %s: %s%n", servletName, ((servletId != null) ? " (id=" + servletId + ")" : ""), servletClass);
                break;
        }
    }

    public void startDocument() throws SAXException {
        System.out.println("parsing started");
    }

    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw (exception);
    }
}

