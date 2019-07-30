package com.parley.parley.repository;

import com.parley.parley.models.Instructor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    Instructor findByUsername(String username);
}