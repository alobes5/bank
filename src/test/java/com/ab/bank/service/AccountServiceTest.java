package com.ab.bank.service;

import com.ab.bank.BankApplication;
import com.ab.bank.entity.BankAccountEntity;
import com.ab.bank.model.Account;
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

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = BankApplication.class)
public class AccountServiceTest {

    @Autowired
    private BankAccountRepository repository;

    @Autowired
    private AccountService service;

    @Before
    public void setUp() {
        repository.save(getAValidAccountEntity());
    }

    @Test
    public void getAccounts() {
        List<Account> actual = service.getAccounts();
        List<Account> expected = getAnExpectedAccountList();

        Account[] lhs = expected.toArray(new Account[expected.size()]);
        Account[] rhs = actual.toArray(new Account[actual.size()]);

        Assert.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs));
    }

    @Test
    public void saveAccount(){
        BankAccountEntity actual = service.save(1l);
        BankAccountEntity expected = getAValidAccountEntity();

        Assert.assertTrue(EqualsBuilder.reflectionEquals(expected,actual));
    }

    @Test
    public void getValidAccount() {
        Account actual = service.getAccount(1l);
        Account expected = getAnExpectedAccount();

        Assert.assertTrue(EqualsBuilder.reflectionEquals(expected, actual));
    }

    private Account getAnExpectedAccount() {
        return new Account(1l, "Aline", "Busato");
    }


    private List<Account> getAnExpectedAccountList() {
        return Arrays.asList(getAnExpectedAccount());
    }

    private BankAccountEntity getAValidAccountEntity() {
        return new BankAccountEntity(1l, "Aline", "Busato", "DE89370400440532013081");
    }
}