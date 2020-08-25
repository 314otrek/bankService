package org.piterconsulting;

import java.util.Objects;

public class Client {
    private String name;
    private String mail;
    private double balance;

    public Client(String name, String mail, double balance) {
        this.name = name;
        this.mail = mail;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Double.compare(client.balance, balance) == 0 &&
                Objects.equals(name, client.name) &&
                Objects.equals(mail, client.mail);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, balance);
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", balance=" + balance +
                '}';
    }
}
