package org.piterconsulting.controllers.dto;

import lombok.Data;


import java.time.OffsetDateTime;
import lombok.*;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

    private double amount;
    private String currency;
    private long accountIdFrom;
    private long accountIdTo;

}
