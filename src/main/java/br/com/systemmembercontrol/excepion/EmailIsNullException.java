package br.com.systemmembercontrol.excepion;

public class EmailIsNullException extends RuntimeException {

    public EmailIsNullException(String message){
        super(message);
    }

    public EmailIsNullException(){

    }
}
