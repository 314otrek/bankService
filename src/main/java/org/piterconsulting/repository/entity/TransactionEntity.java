package org.piterconsulting.repository.entity;


import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "TRANSACTIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class TransactionEntity {

    @Id
    @GeneratedValue
    @Column(name = "TRANSACTION_ID")
    private long id;
    @Column(name = "AMOUNT")
    private double amount;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "TRANSACTION_DATE")
    private OffsetDateTime transactionTime;
    @Column(name = "FROM_ACCOUNT_ID")
    private long accountIdFrom;
    @Column(name = "TO_ACCOUNT_ID")
    private long accountIdTo;




}
