package com.jiyunieo.demo.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    // 프론트에게 보냄
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<CustomErrorDTO> CustomExceptionHandler(CustomException ex){
        return CustomErrorDTO.toResponseEntity(ex);
    }
}
