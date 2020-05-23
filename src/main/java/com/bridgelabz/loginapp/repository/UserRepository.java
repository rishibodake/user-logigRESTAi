package com.bridgelabz.loginapp.repository;

import com.bridgelabz.loginapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
