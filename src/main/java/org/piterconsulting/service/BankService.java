package org.piterconsulting.service;

import org.piterconsulting.repository.ClientRipository;
import org.piterconsulting.repository.ClientSpringJpaRepository;
import org.piterconsulting.repository.HibernateClientRepository;
import org.piterconsulting.repository.JDBCClientRepository;
import org.piterconsulting.repository.annotation.HibernateRepository;
import org.piterconsulting.repository.annotation.JDBCRepository;
import org.piterconsulting.repository.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class BankService {

    private final ClientRipository clientRipository;
    @Autowired
    public BankService(
                    ClientRipository clientRipository ) {
        this.clientRipository = clientRipository;
    }



    public void save(Client client) {
//        if (client.getMail() == null || client.getName() == null) {
//            throw new NullPointerException("Null value in params!");
//        }
//            Client k1 = clientRipository.findByMail(client.getMail());
//            if(k1.getMail().compareTo(client.getMail())==0){
//                throw new SameEmailsException("Same mails!");
//            }
//            else {
                clientRipository.save(client);
//            }
    }

    public Client findByEmail(String mail) {
            return clientRipository.findByMail(mail);
    }

    public void transfer(String fromEmail, String toEmail, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Negative amount is not allowed");
        }

        if (fromEmail.equalsIgnoreCase(toEmail)) {
            throw new IllegalArgumentException("Same emails !!!!");
        }
        Client fromClient = findByEmail(fromEmail);
        Client toClient = findByEmail(toEmail);


        if (fromClient.getBalance() - amount >= 0) {
            fromClient.setBalance(fromClient.getBalance() - amount);
            toClient.setBalance(toClient.getBalance() + amount);
        } else {
            throw new NoSufficientFundsException("Not enough funds!");
        }
    clientRipository.save(fromClient);
        clientRipository.save(toClient);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankService that = (BankService) o;
        return Objects.equals(clientRipository, that.clientRipository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientRipository);
    }

    public void withdraw(
            final String email,
            final double amount) {
        if (Objects.isNull(email)) {
            throw new IllegalArgumentException("Email cant be null!");
        }
        Client k1 = findByEmail(email.toLowerCase());
//        k1.getMail().toLowerCase();
        if (amount > k1.getBalance()) {
            throw new NoSufficientFundsException("Balance is lower than amount to transfer");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        final Client byemail = findByEmail(email.toLowerCase());
        byemail.setBalance(byemail.getBalance() - amount);
    }

    public void delete(String mail){

        if(mail==null){
            throw new IllegalArgumentException("Dont delete user with null mail");
        }
        Client k1 = findByEmail(mail.toLowerCase());
        if(k1.getBalance()!=0){
            throw new NoSuchElementException("This client has positive amount!");
        }
        clientRipository.delete(k1);
    }
}
