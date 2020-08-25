package org.piterconsulting.service;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String s){
        super(s);
    }
}
