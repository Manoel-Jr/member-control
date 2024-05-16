package br.com.systemmembercontrol.excepion;

public class MemberNotFoundException extends RuntimeException{

    public MemberNotFoundException(String message){
        super(message);
    }

    public MemberNotFoundException(){

    }
}
