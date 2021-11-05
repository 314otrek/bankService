package org.piterconsulting.service;

import lombok.RequiredArgsConstructor;
import org.piterconsulting.controllers.dto.CurrencyResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final String API_EXCHANGE = "http://api.exchangeratesapi.io/v1/latest?access_key=36231ca213b26be292632b0ab13c4096";

    private final RestTemplate restTemplate;

    public CurrencyResponse getCurrencyBodyApi(){
        final ResponseEntity<CurrencyResponse> response= restTemplate
                .getForEntity(API_EXCHANGE,
                        CurrencyResponse.class);
        return response.getBody();
    }

    public CurrencyResponse getCurrencyRates(){
        return getCurrencyBodyApi();
    }
    public double getCurrencyValueByName(String name){
        return getCurrencyBodyApi().getRates().get(name);
    }
}
