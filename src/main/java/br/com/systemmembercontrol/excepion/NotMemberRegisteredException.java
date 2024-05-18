package br.com.systemmembercontrol.excepion;

public class NotMemberRegisteredException extends RuntimeException {

    public NotMemberRegisteredException(String message){
        super(message);
    }
    public NotMemberRegisteredException(){

    }
}
