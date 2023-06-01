package com.personal.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.main.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
