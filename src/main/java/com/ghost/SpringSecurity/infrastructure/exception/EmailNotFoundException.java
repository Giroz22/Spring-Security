package com.ghost.SpringSecurity.infrastructure.exception;

public class EmailNotFoundException extends RuntimeException{
    private static String ERROR_MESSAGE = "No se encontro un usuario con ese email";

    public EmailNotFoundException(){
        super(ERROR_MESSAGE);
    }
}
