package com.jzheng.xml;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

public class ParserCompare {
    @Test
    public void saxParser_vs_xmlReader() throws ParserConfigurationException, SAXException, IOException {
        String emp =
                "<Employee id=\"1\">\n" +
                "        <age>29</age>\n" +
                "        <name>Pankaj</name>\n" +
                "        <gender>Male</gender>\n" +
                "        <role>Java Developer</role>\n" +
                "    </Employee>";

        MyHandler handler = new MyHandler();

        // Parse with sax parser
        System.out.println("SaxParser result: ");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser= factory.newSAXParser();
        saxParser.parse(new InputSource(new StringReader(emp)), handler);
        System.out.println(handler.getEmpList());

        System.out.println("XMLReader result: ");
        XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource(new StringReader(emp)));
        System.out.println(handler.getEmpList());
    }
}
