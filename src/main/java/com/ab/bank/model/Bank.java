package com.ab.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bank {

    @NotNull
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

        Bank bank = (Bank) o;

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
