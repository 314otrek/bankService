package org.piterconsulting.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    @Column(name="first_name")
    private String name;
    @Column(name="mail")
    private String mail;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<Account> accounts;

    public Client(String name, String mail, List<Account> accounts) {
        this.name = name;
        this.mail = mail;
        this.accounts = accounts;
    }

    public double getBalance() {
        if(!accounts.isEmpty()){
            return accounts.get(0).getBalance();
        }
        return  0;
    }

    public void setBalance(double v) {
        if(!accounts.isEmpty()){
            accounts.get(0).setBalance(v);
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", accounts='" + accounts + '\'' +

                '}';
    }
}
