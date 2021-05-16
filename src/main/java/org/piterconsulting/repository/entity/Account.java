package org.piterconsulting.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private long id;
    @Column(name = "balance")
    private double balance;
    @Column(name = "currency")
    private String currency;
    @Column(name = "USER_ID")
    private Long userId;

    public Account(double balance,String currency){
        this.balance=balance;
        this.currency=currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}