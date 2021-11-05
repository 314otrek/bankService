package org.piterconsulting.service;

import org.piterconsulting.controllers.dto.TransactionResponse;
import org.piterconsulting.repository.entity.TransactionEntity;
import org.springframework.stereotype.Component;

import javax.transaction.Transaction;
import java.time.LocalDate;

@Component
public class TransactionMapper {

     public TransactionResponse map(TransactionEntity transactionEntity){

         return TransactionResponse.builder()
                 .id(transactionEntity.getId())
                 .amount(transactionEntity.getAmount())
                 .userIdFrom(transactionEntity.getAccountIdFrom())
                 .currency(transactionEntity.getCurrency())
                 .userIdTo(transactionEntity.getAccountIdTo())
                 .transactionTime(transactionEntity.getTransactionTime())
                 .build();
     }


}
