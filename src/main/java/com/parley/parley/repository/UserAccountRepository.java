package com.parley.parley.repository;

import com.parley.parley.models.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    UserAccount findByUsername(String username);
}
