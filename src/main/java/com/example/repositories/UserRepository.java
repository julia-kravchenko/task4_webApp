package com.example.repositories;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    //Optional<User> findById(Long userId);
    @Query(value = "SELECT * FROM USR WHERE id = ?1", nativeQuery = true)
    User findByUserId(Long id);
}

