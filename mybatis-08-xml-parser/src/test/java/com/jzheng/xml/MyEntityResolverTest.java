package com.jzheng.xml;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class MyEntityResolverTest {
    @Test
    public void test() throws ParserConfigurationException, SAXException, IOException {
        String str_with_dtd = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE succession-data-model PUBLIC \"Self_defined_plublic_name\" \"http://self/defined/public/name\">\n" +
                "<succession-data-model>\n" +
                "</succession-data-model>";

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setEntityResolver(new MyEntityResolver());
        xmlReader.parse(new InputSource(new StringReader(str_with_dtd)));
    }
}