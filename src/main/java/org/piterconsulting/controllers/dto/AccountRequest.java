package org.piterconsulting.controllers.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class AccountRequest {

    private double balance;
    private String currency;
    private Long userId;
}
