package org.piterconsulting.controllers;

import lombok.RequiredArgsConstructor;
import org.piterconsulting.controllers.dto.TransactionRequest;
import org.piterconsulting.controllers.dto.TransactionResponse;
import org.piterconsulting.repository.entity.TransactionEntity;
import org.piterconsulting.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TransactionController {


    private final TransactionService service;

    @GetMapping(path = "/api/transaction")
    public ResponseEntity<TransactionResponse> findById(@RequestParam long id) {
        final TransactionResponse transactionEntity = service.findResponseById(id);
        return new ResponseEntity<>(transactionEntity, HttpStatus.ACCEPTED);
    }

    @GetMapping("/api/transactions")
    public List<TransactionEntity> getAllTransactions(){

        return service.getAllTransactions();
    }

    @PostMapping(path = "/api/transaction")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTransaction(@RequestBody TransactionRequest request) {

        service.createTransaction(request);
    }
}