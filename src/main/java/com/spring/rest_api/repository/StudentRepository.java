package com.spring.rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest_api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
