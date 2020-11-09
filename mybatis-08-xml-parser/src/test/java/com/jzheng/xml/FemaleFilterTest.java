package com.jzheng.xml;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.StringReader;

public class FemaleFilterTest {
    @Test
    public void test() throws SAXException, IOException {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<personnel>\n" +
                "  <employee empid=\"332\" deptid=\"24\" shift=\"night\"\n" +
                "         status=\"contact\">\n" +
                "    JennyBerman\n" +
                "  </employee>\n" +
                "  <employee empid=\"994\" deptid=\"24\" shift=\"day\"\n" +
                "         status=\"donotcontact\">\n" +
                "    AndrewFule\n" +
                "  </employee>\n" +
                "  <employee empid=\"948\" deptid=\"3\" shift=\"night\"\n" +
                "         status=\"contact\">\n" +
                "    AnnaBangle\n" +
                "  </employee>\n" +
                "  <employee empid=\"1032\" deptid=\"3\" shift=\"day\"\n" +
                "         status=\"contact\">\n" +
                "    DavidBaines\n" +
                "  </employee>\n" +
                "</personnel>";

        XMLReader reader = XMLReaderFactory.createXMLReader();
        XMLFilter femaleFilter = new FemaleFilter(reader);
        femaleFilter.setContentHandler(new FemaleHandler());
        femaleFilter.parse(new InputSource(new StringReader(xml)));
    }
}