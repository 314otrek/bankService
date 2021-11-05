package org.piterconsulting.controllers.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyResponse {
    private String base;
    private String date;
    private Map<String,Double> rates;
}
