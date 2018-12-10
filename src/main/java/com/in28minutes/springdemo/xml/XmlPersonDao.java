package com.in28minutes.springdemo.xml;

public class XmlPersonDao {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public XmlPersonDao(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
