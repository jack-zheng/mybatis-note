package com.jzheng.xml;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        show("--Warning--", exception);
        throw (exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        show("--Error--", exception);
        throw (exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        show("--Fatal Error--", exception);
        throw (exception);
    }

    private void show(String type, SAXParseException e) {
        System.out.println(type + ": " + e.getMessage());
        System.out.println("Line " + e.getLineNumber() + " Column " + e.getColumnNumber());
        System.out.println("System ID: " + e.getSystemId());
    }
}
