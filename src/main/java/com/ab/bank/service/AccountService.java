package com.ab.bank.service;

import com.ab.bank.entity.BankAccountEntity;
import com.ab.bank.model.Account;
import com.ab.bank.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private static final String IBAN_PREFIX = "DE89370400440532013087";

    private BankAccountRepository repository;

    @Autowired
    public AccountService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAccounts() {
        List<BankAccountEntity> all = repository.findAll();
        List<Account> accounts = all.stream()
                .map(n -> new Account(n.getId(), n.getFirstName(), n.getLastName()))
                .collect(Collectors.toList());
        return accounts;
    }

    public Account getAccount(long id) {
        BankAccountEntity entity = repository.findById(id).get();

        return new Account(entity.getId(), entity.getFirstName(), entity.getLastName());
    }

    public BankAccountEntity save(long id) {
        String firstName = "Aline";
        String lastName = "Busato";
        String iban = getIBANCode(id);
        BankAccountEntity account = new BankAccountEntity(id, firstName, lastName, iban);

        return repository.save(account);
    }

    private String getIBANCode(long id) {
        StringBuilder builder = new StringBuilder();
        int prefix_length = IBAN_PREFIX.length();
        int sufix_length = String.valueOf(id).length();

        builder.append(IBAN_PREFIX.substring(0, prefix_length - sufix_length))
                .append(id);
        return builder.toString();
    }
}
