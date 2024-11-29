package org.example.logisticapplication.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(value = {
            IllegalArgumentException.class,
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<ErrorMessageResponse> illegalArgumentException(
            Exception ex
    ) {
        ErrorMessageResponse response = new ErrorMessageResponse(
                "Illegal argument exception!",
                ex.getMessage(),
                LocalDateTime.now()
        );


        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
