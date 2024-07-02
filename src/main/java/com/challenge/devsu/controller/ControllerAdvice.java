package com.challenge.devsu.controller;

import com.challenge.devsu.dto.ErrorDTO;
import com.challenge.devsu.exception.ClienteNoEncontradoException;
import com.challenge.devsu.exception.TipoCuentaNoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ClienteNoEncontradoException.class)
    public ResponseEntity<ErrorDTO> clienteNoEncontradoExceptionHandler(ClienteNoEncontradoException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-001")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TipoCuentaNoEncontradaException.class)
    public ResponseEntity<ErrorDTO> tipoCuentaNoEncontradaExceptionHandler(TipoCuentaNoEncontradaException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                            .code("P-002")
                            .message(e.getMessage())
                            .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> argumentsNotValidHandler(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
