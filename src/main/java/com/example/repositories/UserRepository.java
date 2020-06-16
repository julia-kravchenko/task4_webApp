package com.example.repositories;

import com.example.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

