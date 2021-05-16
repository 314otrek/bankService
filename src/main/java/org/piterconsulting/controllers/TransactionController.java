package org.piterconsulting.controllers;

import lombok.RequiredArgsConstructor;
import org.piterconsulting.controllers.dto.AccountRequest;
import org.piterconsulting.controllers.dto.AccountResponse;
import org.piterconsulting.controllers.dto.TransactionRequest;
import org.piterconsulting.controllers.dto.TransactionResponse;
import org.piterconsulting.service.AccountService;
import org.piterconsulting.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TransactionController {


    private final TransactionService service;

//    @GetMapping(path = "/api/transaction")
//    public ResponseEntity<AccountResponse> findById(long id) {
//        final TransactionResponse account = service.findById(id);
//        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
//    }

    @PostMapping(path = "/api/transaction")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTransaction(@RequestBody TransactionRequest request) {
        service.createTransaction(request);
    }
}