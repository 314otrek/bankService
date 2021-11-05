package org.piterconsulting.controllers.dto;

import lombok.*;
import lombok.Data;

import javax.persistence.Column;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    private long id;
    private double amount;
    private String currency;
    private OffsetDateTime transactionTime;
    private Long userIdFrom;
    private Long userIdTo;
}
