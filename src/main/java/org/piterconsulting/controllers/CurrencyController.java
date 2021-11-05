package org.piterconsulting.controllers;

import lombok.RequiredArgsConstructor;
import org.piterconsulting.controllers.dto.CurrencyResponse;
import org.piterconsulting.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
        private final CurrencyService currencyService;


        @GetMapping(path = "/api/currency")
    public ResponseEntity<CurrencyResponse> getCurrencyRates(){
            final  CurrencyResponse currencyResponse = currencyService.getCurrencyRates();
            return new ResponseEntity<>(currencyResponse, HttpStatus.ACCEPTED);
        }
}
