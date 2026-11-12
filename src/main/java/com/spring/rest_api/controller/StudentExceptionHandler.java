package com.spring.rest_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.spring.rest_api.entity.StudentErrorResponse;
import com.spring.rest_api.exception.StudentNotFOundException;

@ControllerAdvice 
public class StudentExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> err = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
      err.put(error.getField(), error.getDefaultMessage());
    });
    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler 
  public ResponseEntity<StudentErrorResponse> handleException(StudentNotFOundException ex) {
    
    StudentErrorResponse err = new StudentErrorResponse();

    err.setStatus(HttpStatus.NOT_FOUND.value());
    err.setMessage(ex.getMessage());
    err.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler 
  public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
    
    StudentErrorResponse err = new StudentErrorResponse();

    err.setStatus(HttpStatus.BAD_REQUEST.value());
    err.setMessage("Invalid data. Only integers are accepted.");
    err.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }
}
