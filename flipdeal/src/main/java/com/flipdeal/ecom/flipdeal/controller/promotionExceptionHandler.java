package com.flipdeal.ecom.flipdeal.controller;

import com.flipdeal.ecom.flipdeal.Exception.ServerCustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class promotionExceptionHandler {

    @ExceptionHandler({ServerCustomException.class})
    public ResponseEntity<Object> ServerCustomException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>("no strategy present for this given promotion type", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
