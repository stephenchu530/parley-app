package com.parley.parley.repository;

import com.parley.parley.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByUsername(String username);
}
