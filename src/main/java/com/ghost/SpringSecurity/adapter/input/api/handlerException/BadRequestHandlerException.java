package com.ghost.SpringSecurity.adapter.input.api.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ghost.SpringSecurity.adapter.input.api.dto.response.ErrorResponse;
import com.ghost.SpringSecurity.adapter.input.api.dto.response.ErrorsResponse;
import com.ghost.SpringSecurity.infrastructure.exception.EmailNotFoundException;
import com.ghost.SpringSecurity.infrastructure.exception.IdNotFoundException;

@ControllerAdvice
public class BadRequestHandlerException {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleIdNotFound(IdNotFoundException ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .error(
                ex.getMessage()
            )
            .build()
        );
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmailNotfound(EmailNotFoundException ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .status(HttpStatus.BAD_REQUEST.name())
            .code(HttpStatus.BAD_REQUEST.value())
            .error(ex.getMessage())
            .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsResponse> handleValidation(MethodArgumentNotValidException ex){
        return ResponseEntity.badRequest().body(
            ErrorsResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .errors(
                ex.getFieldErrors()
                    .stream()
                    .map(
                        (error) -> error.getDefaultMessage()
                    )
                    .toList()
            )
            .build()
        );
    }
}
