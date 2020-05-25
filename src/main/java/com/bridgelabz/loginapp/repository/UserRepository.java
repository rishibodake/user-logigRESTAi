/*
@file         :UserRepository.java
@overview     :This Class is for configuration for hibernate
@author       :Hrishikesh M Bodake (rishibodake@gmail.com)
@version      :1.0
@since        :20/5/2020
 */
package com.bridgelabz.loginapp.repository;

import com.bridgelabz.loginapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
