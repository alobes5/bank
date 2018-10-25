package com.ab.bank.service;

import com.ab.bank.entity.BankAccountEntity;
import com.ab.bank.model.Bank;
import com.ab.bank.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private BankAccountRepository repository;

    @Autowired
    public BankService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public Bank getBankAccount(long id) {
        BankAccountEntity bankAccountEntity = repository.findById(id).get();

        return new Bank(bankAccountEntity.getId(), bankAccountEntity.getFirstName(), bankAccountEntity.getLastName(), bankAccountEntity.getIBAN());
    }

}
