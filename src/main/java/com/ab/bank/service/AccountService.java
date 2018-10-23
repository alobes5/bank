package com.ab.bank.service;

import com.ab.bank.entity.AccountEntity;
import com.ab.bank.model.Account;
import com.ab.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAccounts() {
        List<AccountEntity> all = repository.findAll();
        List<Account> accounts = all.stream()
                .map(n -> new Account(n.getId(), n.getFirstName(), n.getLastName()))
                .collect(Collectors.toList());
        return accounts;
    }

    public Account getAccount(long id) {
        AccountEntity entity = repository.findById(id).get();

        return new Account(entity.getId(), entity.getFirstName(), entity.getLastName());
    }
}
