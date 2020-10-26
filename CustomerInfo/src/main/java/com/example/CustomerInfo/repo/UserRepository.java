package com.example.CustomerInfo.repo;

import com.example.CustomerInfo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<User> findAllByUsernameContainingIgnoreCase(String username);
    User findUserByUsername(String username);
}
