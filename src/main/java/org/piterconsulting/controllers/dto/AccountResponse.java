package org.piterconsulting.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class AccountResponse {

    private long id;
    private double balance;
    private String currency;
    private Long userId;

}
