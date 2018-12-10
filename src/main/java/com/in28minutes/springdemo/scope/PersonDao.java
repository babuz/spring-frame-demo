package com.in28minutes.springdemo.scope;

public class PersonDao {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonDao(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
