package com.ab.bank.controller;

import com.ab.bank.model.Account;
import com.ab.bank.service.AccountService;
import com.sun.xml.internal.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private static final String PATH = "/accounts";
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping(PATH)
    public ResponseEntity<List<Account>> getAcccounts() {
        return new ResponseEntity<>(service.getAccounts(), HttpStatus.OK);
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<Account> getAcccount(@PathVariable long id) {
        return new ResponseEntity<>(service.getAccount(id), HttpStatus.OK);
    }

    @PostMapping(PATH + "/{id}")
    public ResponseEntity createAnAccount(@PathVariable long id) {
        //TODO: implement post
        return new ResponseEntity(HttpStatus.OK);
    }
}
