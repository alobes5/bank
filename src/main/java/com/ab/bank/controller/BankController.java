package com.ab.bank.controller;

import com.ab.bank.model.Bank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    private static final String PATH = "/bank";
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping(PATH + "/{id}")
    public Bank getBank(@PathVariable long id) {
        return new Bank(1, "fn", "ln", "IBAN");
    }

}
