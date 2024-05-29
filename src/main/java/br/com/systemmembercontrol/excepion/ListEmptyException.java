package br.com.systemmembercontrol.excepion;

public class ListEmptyException extends RuntimeException{

    public ListEmptyException(String message){
        super(message);
    }

    public ListEmptyException(){

    }
}
