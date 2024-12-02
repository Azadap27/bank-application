package com.bank.application.service.impl;

import com.bank.AccountsApi;
import com.bank.application.repository.AccountRepository;
import com.bank.application.repository.PersonRepository;
import com.bank.application.repository.entity.Account;
import com.bank.application.repository.entity.Person;
import com.bank.application.service.AccountMapper;
import com.bank.application.service.PersonMapper;
import com.bank.application.service.TransferMapper;
import com.bank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountsApi {

    private AccountRepository accountRepository;

    private PersonRepository personRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PersonRepository personRepository) {
        this.accountRepository = accountRepository;
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<AccountResponse> createAccount(AccountRequest accountRequest) {
        createPerson(accountRequest);
        Account account = saveAccount(AccountMapper.mapToAccountEntity(accountRequest, new Account()));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AccountMapper.mapToAccountResponse(account, new AccountResponse()));
    }

    private void createPerson(AccountRequest accountRequest) {
        personRepository.save(PersonMapper.mapToPersonEntity(accountRequest.getPerson(), new Person()));
    }

    @Override
    public ResponseEntity<AccountResponse> getAccount(Long accountId) {
        Account account = getAccountById(accountId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(AccountMapper.mapToAccountResponse(account, new AccountResponse()));
    }

    @Override
    public ResponseEntity<PersonResponse> getPerson(Long personId) {
        Person person = personRepository.getReferenceById(personId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(PersonMapper.mapToPersonResponse(person, new PersonResponse()));
    }

    @Override
    public ResponseEntity<TransferResponse> transferAmount(TransferRequest transferRequest) {
        Account senderAccount = getAccountById(transferRequest.getSenderAccount());
        Account receiverAccount = getAccountById(transferRequest.getReceiverAccount());

        Long existingSenderBalance = senderAccount.getBalance();
        if (existingSenderBalance <= transferRequest.getAmount()){
            senderAccount.setBalance(existingSenderBalance - transferRequest.getAmount());
        }// else throw exception account balance low

        Long existingReceiverBalance = receiverAccount.getBalance();
        receiverAccount.setBalance(existingReceiverBalance + transferRequest.getAmount());

        saveAccount(senderAccount);
        saveAccount(receiverAccount);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(TransferMapper.mapToTransferResponse11(transferRequest, new TransferResponse()));
    }

    private Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    private Account getAccountById(Long accountId) {
        return accountRepository.getReferenceById(accountId);
    }
}
