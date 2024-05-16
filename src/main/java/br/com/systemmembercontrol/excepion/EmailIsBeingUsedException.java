package br.com.systemmembercontrol.excepion;

public class EmailIsBeingUsedException extends RuntimeException{

    public EmailIsBeingUsedException(String message){
        super(message);
    }

    public EmailIsBeingUsedException(){

    }
}
