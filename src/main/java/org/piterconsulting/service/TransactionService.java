package org.piterconsulting.service;

import lombok.RequiredArgsConstructor;
import org.piterconsulting.controllers.dto.TransactionRequest;
import org.piterconsulting.repository.TransactionRepository;
import org.piterconsulting.repository.entity.TransactionEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransactionService {


    private final TransactionRepository repository;
    private  final AccountService accountService;

    public TransactionService(TransactionRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }

    public void createTransaction(TransactionRequest request){
        accountService.transfer(
                request.getAccountIdFrom()
                ,request.getAccountIdTo()
                ,request.getAmount()
        );

        repository.save(
                TransactionEntity.builder()
                        .amount(request.getAmount())
                        .currency(request.getCurrency())
                        .accountIdFrom(request.getAccountIdFrom())
                        .accountIdTo(request.getAccountIdTo())
                        .transactionTime(
                                OffsetDateTime.now())
                        .build()
        );
    }
}
