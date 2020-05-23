package com.bridgelabz.loginapp.service;

import com.bridgelabz.loginapp.dto.UserLoginDTO;
import com.bridgelabz.loginapp.entity.User;
import com.bridgelabz.loginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAndRegisterService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {

        User findUser =  userRepository.findByEmail(user.getEmail());
        if(findUser == null){
            userRepository.save(user);
            return "User Registered";
        }
        return "User Is Already Registered with this Email Id";
    }
}
