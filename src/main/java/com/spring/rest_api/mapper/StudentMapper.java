package com.spring.rest_api.mapper;

import com.spring.rest_api.dto.StudentDto;
import com.spring.rest_api.entity.Student;

public class StudentMapper {

  public static StudentDto mapToStudentDto(Student saved) {
    return new StudentDto(saved.getId(),
                          saved.getFirstName(),
                          saved.getLastName(),
                          saved.getEmail());
  }

  public static Student mapToStudent(StudentDto theStudentDto) {
    return new Student(theStudentDto.getId(),
                       theStudentDto.getFirstName(),
                       theStudentDto.getLastName(),
                       theStudentDto.getEmail());
  }

  
}
