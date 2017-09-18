package com.epam.courses.jf.se10.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class SAXExample {

    public static void main(String[] args) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {

            }

            @Override
            public void fatalError(SAXParseException ex) throws SAXException {
                System.out.println("Fatal error: " + ex.getLineNumber() + ":" + ex.getColumnNumber());
            }
        });
        reader.setContentHandler(new ContentHandler() {

            private Locator locator;

            @Override
            public void setDocumentLocator(Locator locator) {
                this.locator = locator;
            }

            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start parsing document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End parsing document");
            }

            @Override
            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println("Mapping " + uri + " to " + prefix);
            }

            @Override
            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println("End mapping " + prefix);
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                System.out.println(String.join(" | ", "Start element", uri, localName, qName));
                System.out.println(atts.getValue(0));
                System.out.println(atts.getValue(1));
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println(String.join(" | ", "End element", uri, localName, qName));
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Character data: " + new String(ch, start, length));
            }

            @Override
            public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

            }

            @Override
            public void processingInstruction(String target, String data) throws SAXException {
                System.out.println("Processing instruction: " + target + " = " + data);
            }

            @Override
            public void skippedEntity(String name) throws SAXException {
                System.out.println("Skipped intity: " + name + " in position " + locator.getLineNumber() + ":" + locator.getColumnNumber());
            }
        });
        reader.parse(new InputSource(new FileInputStream("C:\\Users\\Nikolai_Plokhoi\\IdeaProjects\\epam-summer-2017\\src\\main\\resources\\com\\epam\\courses\\jf\\se10\\students.xml")));
    }
}
