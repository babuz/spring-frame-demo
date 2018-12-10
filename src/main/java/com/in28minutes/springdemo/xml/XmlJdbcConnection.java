package com.in28minutes.springdemo.xml;

import org.springframework.stereotype.Component;

@Component
public class XmlJdbcConnection {
    private XmlPersonDao xmlPersonDao;
    public XmlJdbcConnection() {
    }

    public XmlPersonDao getXmlPersonDao() {
        return xmlPersonDao;
    }

    public void setXmlPersonDao(XmlPersonDao xmlPersonDao) {
        this.xmlPersonDao = xmlPersonDao;
    }
}
