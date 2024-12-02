package com.bank.application.service;

import com.bank.application.repository.entity.Account;
import com.bank.application.repository.entity.Person;
import com.bank.model.AccountRequest;
import com.bank.model.AccountResponse;
import com.bank.model.PersonResponse;

public class AccountMapper {
    public static AccountResponse mapToAccountResponse(Account account, AccountResponse accountResponse){
        accountResponse.setPerson(PersonMapper.mapToPersonResponse(account.getPerson(), new PersonResponse()));
        accountResponse.setBalance(account.getBalance());

        return accountResponse;
    }

    public static Account mapToAccountEntity(AccountRequest accountRequest, Account account){
        account.setPerson(PersonMapper.mapToPersonEntity(accountRequest.getPerson(), new Person()));
        account.setBalance(accountRequest.getInitialCredit());

        return account;
    }

    public static AccountResponse mapToAccountResponse11(AccountRequest accountRequest, AccountResponse accountResponse){
        accountResponse.setPerson(PersonMapper.mapToPersonResponse11(accountRequest.getPerson(), new PersonResponse()));
        accountResponse.setBalance(accountRequest.getInitialCredit());

        return accountResponse;
    }
}
