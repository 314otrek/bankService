package org.piterconsulting.service;

import org.piterconsulting.controllers.dto.TransactionRequest;
import org.piterconsulting.controllers.dto.TransactionResponse;
import org.piterconsulting.repository.TransactionRepository;
import org.piterconsulting.repository.entity.TransactionEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class TransactionService {


    private final TransactionRepository repository;
    private  final AccountService accountService;
    private final TransactionMapper mapper;



    public TransactionService(TransactionRepository repository, AccountService accountService, TransactionMapper mapper) {
        this.repository = repository;
        this.accountService = accountService;
        this.mapper = mapper;
    }
    public TransactionEntity findById(long id){
        return repository.findById(id);
    }
    public TransactionResponse findResponseById(long id){
        final TransactionEntity transactionEntity = findById(id);
        return mapper.map(transactionEntity);
    }

    public List<TransactionEntity> getAllTransactions(){
        return repository.findAll();
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
