package br.com.systemmembercontrol.excepion;

public class CpfIsNullException extends RuntimeException{

    public CpfIsNullException(String message){
        super(message);
    }

    public CpfIsNullException(){

    }
}
