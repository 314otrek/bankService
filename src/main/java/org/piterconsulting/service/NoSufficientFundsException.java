package org.piterconsulting.service;

public class NoSufficientFundsException  extends  RuntimeException{
   public NoSufficientFundsException(String message){
       super(message);
   }

}
