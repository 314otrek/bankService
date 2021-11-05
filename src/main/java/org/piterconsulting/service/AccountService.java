package org.piterconsulting.service;

import org.piterconsulting.controllers.dto.AccountRequest;
import org.piterconsulting.controllers.dto.AccountResponse;
import org.piterconsulting.repository.AccountRepository;
import org.piterconsulting.repository.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public AccountResponse findById(long id) {
        return repository
                .findById(id)
                .map(account -> AccountResponse.builder()
                        .balance(account.getBalance())
                        .currency(account.getCurrency())
                        .userId(account.getUserId())
                        .id(account.getId())
                        .build()
                )
                .orElseThrow(() -> new IllegalArgumentException("Account with " + id + " not found"));
    }
    public void addAccount(AccountRequest account) {
        repository.save(
                Account.builder()
                        .balance(account.getBalance())
                        .currency(account.getCurrency())
                        .userId(account.getUserId())
                        .build()
        );

    }

    public void transfer(long fromAccountId, long toAccountId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Negative amount is not allowed");
        }
        Account accountFrom = repository.getOne(fromAccountId);
        Account accountTo = repository.getOne(toAccountId);


        if (accountFrom.getBalance() - amount >= 0) {
            accountFrom.setBalance(accountFrom.getBalance() - amount);
            accountTo.setBalance(accountTo.getBalance() + amount);
        }else{
            throw new NoSufficientFundsException("Not enough money in bank!");
        }
        repository.save(accountFrom);
        repository.save(accountTo);
    }


}
