package com.ab.bank.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankEntity {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String IBAN;

    public BankEntity() {
    }

    public BankEntity(long id, String firstName, String lastName, String IBAN) {
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


    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("IBAN", IBAN)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BankEntity bank = (BankEntity) o;

        return new EqualsBuilder()
                .append(id, bank.id)
                .append(firstName, bank.firstName)
                .append(lastName, bank.lastName)
                .append(IBAN, bank.IBAN)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(IBAN)
                .toHashCode();
    }
}
