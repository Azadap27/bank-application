package com.bank.application.controller;

import com.bank.AccountApi;
import com.bank.model.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AccountController implements AccountApi {
    @Override
    public ResponseEntity<AccountDto> createAccount(AccountDto body) {
        return AccountApi.super.createAccount(body);
    }

    @Override
    public ResponseEntity<List<AccountDto>> getAccount() {
        return AccountApi.super.getAccount();
    }
}

