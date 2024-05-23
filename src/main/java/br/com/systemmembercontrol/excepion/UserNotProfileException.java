package br.com.systemmembercontrol.excepion;

public class UserNotProfileException extends RuntimeException{

    public UserNotProfileException(String message){
        super(message);
    }

    public UserNotProfileException(){

    }
}
