package org.piterconsulting.service;

public class SameMailsException extends RuntimeException{
    public SameMailsException(String message){
        super(message);
    }
}
