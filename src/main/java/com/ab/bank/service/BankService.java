package com.ab.bank.service;

import com.ab.bank.entity.BankEntity;
import com.ab.bank.model.Bank;
import com.ab.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private BankRepository repository;

    @Autowired
    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    public Bank getBankAccount(long id) {
        BankEntity bankEntity = repository.findById(id).get();

        return new Bank(bankEntity.getId(), bankEntity.getFirstName(), bankEntity.getLastName(), bankEntity.getIBAN());
    }
}
