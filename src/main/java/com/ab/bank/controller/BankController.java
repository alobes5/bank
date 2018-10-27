package com.ab.bank.controller;

import com.ab.bank.model.Bank;
import com.ab.bank.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    private static final String PATH = "/bank";
    private final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());

    private BankService service;

    @Autowired
    public BankController(BankService service) {
        this.service = service;
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<Bank> getBank(@PathVariable long id) {
        log.info("Getting the Bank: {}",id);
        return new ResponseEntity<>(service.getBankAccount(id), HttpStatus.OK);
    }

}
