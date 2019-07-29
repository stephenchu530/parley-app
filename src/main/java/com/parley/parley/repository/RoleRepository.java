package com.parley.parley.repository;

import com.parley.parley.models.RoleType;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<RoleType, Long> {
    RoleType findByRole(String role);
}
