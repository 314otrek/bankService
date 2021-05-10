package org.piterconsulting.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private long id;
    @Column(name = "balance")
    private double balance;
    @Column(name = "currency")
    private String currency;

    public Account(double balance,String currency){
        this.balance=balance;
        this.currency=currency;
    }


}