package com.ab.bank.model;

public class Bank {

    private long id;
    private String firstName;
    private String lastName;
    private String IBAN;

    public Bank(long id, String firstName, String lastName, String IBAN) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.IBAN = IBAN;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIBAN() {
        return IBAN;
    }
}
