package org.piterconsulting.service;

import org.piterconsulting.Client;
import org.piterconsulting.repository.ClientRipository;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class BankService {
    private final ClientRipository clientRipository;

    public BankService(ClientRipository clientRipository) {
        this.clientRipository = clientRipository;
    }

    private boolean emailExists(Set<Client> clientSet, String email) {
        return clientSet
                .stream()
                .anyMatch(client -> Objects.equals(client.getMail(), email.toLowerCase()));
    }


    public void save(Client client) {
        if (client.getMail() == null || client.getName() == null) {
            throw new NullPointerException("Null value in params!");
        }
        if (clientRipository.isExistMail(client.getMail())) {
            Client k1 = clientRipository.findByEmail22(client.getMail());
            if (k1.getName().compareTo(client.getName()) == 0) {
                throw new thisManAlreadyExistInBaseException("This man exist in base");
            } else {
                throw new SameEmailsException("Same mails!");
            }
        } else {
            client.getMail().toLowerCase();
            clientRipository.save(client);
        }
    }

    public Client findByEmail(String email) {

        if (clientRipository.isExistMail(email)) {
            return clientRipository.findByEmail22(email);
        } else {
            throw new NoSuchElementException("lack of this man in base:");
        }
    }

    public void transfer(String fromEmail, String toEmail, double amount) {


        if (!clientRipository.isExistMail(fromEmail) || !clientRipository.isExistMail(toEmail)) {
            throw new NullPointerException("No one of this man in base!");
        }
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

        if (!clientRipository.isExistMail(mail.toLowerCase())) {
            throw new NoSuchElementException("No this man in base");
        }
        Client k1 = findByEmail(mail.toLowerCase());
        if(k1.getBalance()!=0){
            throw new NoSuchElementException("This client has positive amount!");
        }
        clientRipository.delete(k1);
    }
}
