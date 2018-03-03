package com.bankaccount.Exception;

import com.bankaccount.DAO.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex){

        ErrorResponse error= new ErrorResponse();
        error.setErrorcode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}

