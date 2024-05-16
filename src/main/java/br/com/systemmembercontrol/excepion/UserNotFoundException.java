package br.com.systemmembercontrol.excepion;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(){

    }
}
