package com.challenge.devsu.controller;

import com.challenge.devsu.dto.ErrorDTO;
import com.challenge.devsu.exception.*;
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

    @ExceptionHandler(value = ClienteInexistenteException.class)
    public ResponseEntity<ErrorDTO> clienteInexistenteExceptionHandler(ClienteInexistenteException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-001")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TipoCuentaInexistenteException.class)
    public ResponseEntity<ErrorDTO> tipoCuentaInexistenteExceptionHandler(TipoCuentaInexistenteException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                            .code("P-002")
                            .message(e.getMessage())
                            .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CuentaInexistenteException.class)
    public ResponseEntity<ErrorDTO> cuentaInexistenteExceptionHandler(CuentaInexistenteException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-003")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MovimientoInexistenteException.class)
    public ResponseEntity<ErrorDTO> movimientoInexistenteExceptionHandler(MovimientoInexistenteException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-004")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TipoMovimientoInexistenteException.class)
    public ResponseEntity<ErrorDTO> tipoMovimientoInexistenteExceptionHandler(TipoMovimientoInexistenteException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-005")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ValidacionNegocioException.class)
    public ResponseEntity<ErrorDTO> validacionNegocioExceptionExceptionHandler(ValidacionNegocioException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-006")
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
