package com.spring.rest_api.exception;

import com.spring.rest_api.entity.Student;

public class StudentNotFOundException extends RuntimeException {

  private static final long serialVersionUID = 2690100046087976236L;

  public StudentNotFOundException(String message, Throwable cause){
    super(message, cause);
  }

  public StudentNotFOundException(String message) {
    super(message);
  }

  public StudentNotFOundException(Throwable cause) {
    super(cause);
  }
}
