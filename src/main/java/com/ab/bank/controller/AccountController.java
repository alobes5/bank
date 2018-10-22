package com.ab.bank.controller;

import com.ab.bank.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AccountController {

    private static final String PATH = "/accounts";
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping(PATH)
    public ResponseEntity<List<Account>> getAcccounts() {
        Account account = new Account(1l, "fN", "Ln");
        List<Account> accounts = Arrays.asList(account);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<Account> getAcccount(@PathVariable long id) {
        Account account = new Account(1l, "fN", "Ln");
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping(PATH + "/{id}")
    public ResponseEntity createAnAccount(@PathVariable long id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
