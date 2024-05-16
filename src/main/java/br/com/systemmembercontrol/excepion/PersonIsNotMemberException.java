package br.com.systemmembercontrol.excepion;

public class PersonIsNotMemberException extends RuntimeException{

    public PersonIsNotMemberException(String message){
        super(message);
    }

    public PersonIsNotMemberException(){

    }
}
