package org.piterconsulting.service;

import com.sun.xml.bind.v2.TODO;
import org.piterconsulting.controllers.dto.AccountRequest;
import org.piterconsulting.controllers.dto.AccountResponse;
import org.piterconsulting.repository.AccountRepository;
import org.piterconsulting.repository.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository repository;
    private final CurrencyService currencyService;


    public AccountService(AccountRepository repository, CurrencyService currencyService) {
        this.repository = repository;
        this.currencyService = currencyService;
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
        String currencyFrom = accountFrom.getCurrency().toUpperCase();
        String currencyTo = accountTo.getCurrency().toUpperCase();


        if (accountFrom.getBalance() - amount >= 0) {
            accountFrom.setBalance(accountFrom.getBalance() - amount);

                if(!currencyFrom.equals(currencyTo)) {
                    double fromCounter = currencyService.getCurrencyValueByName(currencyFrom);
                    double toCounter = currencyService.getCurrencyValueByName(currencyTo);
                    amount = (amount / fromCounter) * toCounter;
                }
            accountTo.setBalance(accountTo.getBalance() + amount);
        }else{
            throw new NoSufficientFundsException("Not enough money in bank!");
        }
        repository.save(accountFrom);
        repository.save(accountTo);
    }


}
