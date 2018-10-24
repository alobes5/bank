package com.ab.bank.controller;

import com.ab.bank.model.Account;
import com.ab.bank.service.AccountService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountEntityControllerITest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @MockBean
    private AccountService service;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldGetAcccounts() throws Exception {
        Mockito.when(service.getAccounts()).thenReturn(Lists.emptyList());
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));

    }

    @Test
    public void shouldGetAccountsWithId() throws Exception {
        Mockito.when(service.getAccount(Mockito.anyLong()))
                .thenReturn(new Account(1l, "Aline", "Busato"));
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldPostAccountsWithId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}