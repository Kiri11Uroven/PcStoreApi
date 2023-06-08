package com.MyIdeas.pcStore.exceptionhandler;

import com.MyIdeas.pcStore.exception.NullProductPropertiesException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError handle(NullProductPropertiesException exception) {
        return new ResponseError(exception.getMessage(), HttpStatus.NO_CONTENT);
    }
}
