package com.MyIdeas.pcstore.exceptionHandler;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@Slf4j
@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError handle(NullProductPropertiesException exception){
        return new ResponseError(exception.getMessage(), HttpStatus.NO_CONTENT);
    }
}
