package com.jzheng.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

public class FemaleFilter extends XMLFilterImpl {

    public FemaleFilter (XMLReader parent)
    {
        super(parent);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if ("employee".equals(qName) && atts.getValue("deptid").equals("3")) {
            super.startElement(uri, localName, qName, atts);
        }
    }
}
