package com.spring.rest_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class StudentDto {

  private Long id;

  @Size(min=2, max=50, message="Must be 2 to 50 characters.")
  private String firstName;

  @Size(min=2, max=50, message="Must be 2 to 50 characters.")
  private String lastName;

  @Email(message="Email is required and should be valid.")
  private String email;

  public StudentDto(Long id, String firstName, String lastName, String email){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
      return "Student [id=" + id
              + ", firstName='" + firstName + '\''
              + ", lastName='" + lastName + '\''
              + ", email='" + email + '\''
              + ']';
  }

}
