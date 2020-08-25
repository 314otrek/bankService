package org.piterconsulting.service;

public class SameEmailsException  extends  RuntimeException{
    public SameEmailsException(String s) {
        super(s);
    }
}
