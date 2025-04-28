package com.ghost.SpringSecurity.infrastructure.exception;

public class IdNotFoundException extends RuntimeException{
    private static String ERROR_MESSAGE = "No se encontro un %s con ese nombre";

    public IdNotFoundException(String nameEntity){
        super(String.format(ERROR_MESSAGE, nameEntity));
    }
}
