package com.ab.bank.service;

import com.ab.bank.BankApplication;
import com.ab.bank.entity.BankAccountEntity;
import com.ab.bank.model.Bank;
import com.ab.bank.repository.BankAccountRepository;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = BankApplication.class)
public class BankServiceTest {
    @Autowired
    private BankAccountRepository repository;

    @Autowired
    private BankService service;

    @Before
    public void setUp() {
        repository.save(getAValidBankAccountEntity());
    }

    @Test
    public void getBankAccount() {
        Bank actual = service.getBankAccount(1l);
        Bank expected = getAnExpectedBankAccount();

        Assert.assertTrue(EqualsBuilder.reflectionEquals(expected, actual));
    }

    private Bank getAnExpectedBankAccount() {
        return new Bank(1l, "Aline", "Busato", "DE89370400440532013087");
    }

    private BankAccountEntity getAValidBankAccountEntity() {
        return new BankAccountEntity(1l, "Aline", "Busato", "DE89370400440532013087");
    }
}