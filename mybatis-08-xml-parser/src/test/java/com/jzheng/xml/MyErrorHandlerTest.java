package com.jzheng.xml;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Objects;

public class MyErrorHandlerTest {
    @Test
    public void test() throws ParserConfigurationException, SAXException, IOException {
        String str_with_dtd =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE Employees [\n" +
                "        <!ELEMENT Employees (Employee)*>\n" +
                "        <!ELEMENT Employee (age?, name?, gender+, role*)>\n" +
                "        <!ATTLIST Employee\n" +
                "                id CDATA #REQUIRED\n" +
                "                >\n" +
                "        <!ELEMENT age (#PCDATA)>\n" +
                "        <!ELEMENT name (#PCDATA)>\n" +
                "        <!ELEMENT gender (#PCDATA)>\n" +
                "        <!ELEMENT role (#PCDATA)>\n" +
                "        ]>\n" +
                "<Employees>\n" +
                "    <Employee id=\"1\">\n" +
                "        <age>29</age>\n" +
                "        <name>Pankaj</name>\n" +
//                "        <gender>Male</gender>\n" +
                "        <role>Java Developer</role>\n" +
                "    </Employee>\n" +
                "</Employees>";

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setFeature("http://xml.org/sax/features/validation", true);
        xmlReader.setErrorHandler(new MyErrorHandler());
        xmlReader.parse(new InputSource(new StringReader(str_with_dtd)));
    }
}