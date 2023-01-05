package com.example.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TutorialNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notfoundHandler(TutorialNotFoundException ex){
        return ex.getMessage();
    }
}
