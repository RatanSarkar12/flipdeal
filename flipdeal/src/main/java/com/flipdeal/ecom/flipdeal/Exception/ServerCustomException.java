package com.flipdeal.ecom.flipdeal.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerCustomException extends RuntimeException{

     public ServerCustomException(String massage){
         super(massage);
     }

     public ServerCustomException(String massage,Throwable cause){

         super(massage,cause);
     }
}
