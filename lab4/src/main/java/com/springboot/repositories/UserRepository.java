package com.springboot.repositories;

import com.springboot.domain.User_;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User_, Long> {
    boolean existsByEmail(String email);
    User_ findByEmail(String email);
}
