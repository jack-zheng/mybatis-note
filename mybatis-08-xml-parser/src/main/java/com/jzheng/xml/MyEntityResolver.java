package com.jzheng.xml;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

public class MyEntityResolver implements EntityResolver {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) {
        System.out.println(String.format("----- Call MyEntityResolver, PID: %s + SID: + %s", publicId, systemId));
        return null;
    }
}
