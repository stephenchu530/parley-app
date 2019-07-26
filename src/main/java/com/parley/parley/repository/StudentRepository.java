package com.parley.parley.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {
    Student findByUsername(String username);
}
