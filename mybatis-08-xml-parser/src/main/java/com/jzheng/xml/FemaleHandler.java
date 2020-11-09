package com.jzheng.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class FemaleHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("employee".equals(qName)) {
            System.out.printf("QName: %s, id: %s, deptid: %s %n", qName, attributes.getValue("empid"), attributes.getValue("deptid"));
        }
    }
}
