package com.pmoran.devsu.service.cuenta.error;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException(ConstraintViolationException exception) {
        List<String> details = new ArrayList<>();
        for(ConstraintViolation error : exception.getConstraintViolations()) {
            details.add(error.getMessage());
        }
        return new ResponseEntity<>(getErrorMessage(HttpStatus.BAD_REQUEST, details),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException(MethodArgumentNotValidException exception) {
        List<String> details = new ArrayList<>();
        for(FieldError error : exception.getBindingResult().getFieldErrors()) {
            details.add(error.getDefaultMessage());
        }
        return new ResponseEntity<>(getErrorMessage(HttpStatus.BAD_REQUEST, details),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException(HttpMessageNotReadableException exception) {
        return new ResponseEntity<>(getErrorMessage(HttpStatus.BAD_REQUEST, List.of(exception.getMessage())),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException(ResourceNotFoundException exception) {
        return new ResponseEntity<>(getErrorMessage(HttpStatus.NOT_FOUND, List.of(exception.getMessage())),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException(ResourceDuplicationException exception) {
        return new ResponseEntity<>(getErrorMessage(HttpStatus.BAD_REQUEST, List.of(exception.getMessage())),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException(Throwable ex) {
        return new ResponseEntity<>(getErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, List.of(ex.getMessage())),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorMessage getErrorMessage(HttpStatus status, List<String> details) {
        return new ErrorMessage(status, details);
    }

}
