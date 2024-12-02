package com.bank.application.controller;

import com.bank.AccountsApi;
import com.bank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    private AccountsApi accountsApi;

    @Autowired
    public AccountController(AccountsApi accountsApi) {
        this.accountsApi = accountsApi;
    }

    @PostMapping(path = "/accounts")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest accountRequest) {
        return accountsApi.createAccount(accountRequest);
    }

    @GetMapping(path = "/accounts/{accountId}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable Long accountId){
        return accountsApi.getAccount(accountId);
    }

    @GetMapping(path = "/accounts/person/{personId}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable Long personId){
        return accountsApi.getPerson(personId);
    }

    @PostMapping(path = "/accounts/transfer")
    public ResponseEntity<TransferResponse> transferAmount(@RequestBody TransferRequest transferRequest) {
        return accountsApi.transferAmount(transferRequest);
    }
}

