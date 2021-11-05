package org.piterconsulting.controllers;


import lombok.RequiredArgsConstructor;
import org.piterconsulting.controllers.dto.AccountRequest;
import org.piterconsulting.controllers.dto.AccountResponse;
import org.piterconsulting.controllers.dto.ClientRequest;
import org.piterconsulting.controllers.dto.ClientResponse;
import org.piterconsulting.repository.entity.Account;
import org.piterconsulting.service.AccountService;
import org.piterconsulting.service.ClientService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AcountController {


    private final AccountService service;
    @GetMapping(path = "/api/account")
    public ResponseEntity<AccountResponse> findById(long id){
        final AccountResponse account = service.findById(id);
//        final HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("EXAMPLE_Header","Wariacik_INFO");
        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);

    }
    @PostMapping(path = "/api/account")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void  addAccount(@RequestBody AccountRequest account){
        service.addAccount(account);
}
    }


