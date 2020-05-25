/*
@file         :LoginAndRegisterService.java
@overview     :This class contains all the methods that will do all the CRUD operations
@author       :Hrishikesh M Bodake (rishibodake@gmail.com)
@version      :1.0
@since        :20/5/2020
 */
package com.bridgelabz.loginapp.service;

import com.bridgelabz.loginapp.dto.UserLoginDTO;
import com.bridgelabz.loginapp.entity.User;
import com.bridgelabz.loginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class LoginAndRegisterService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {

        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", Pattern.CASE_INSENSITIVE);

        if(user.getEmail().matches(String.valueOf(VALID_EMAIL_ADDRESS_REGEX))) {
            User findUser = userRepository.findByEmail(user.getEmail());
            if (findUser == null) {
                userRepository.save(user);
                return "User Registered";
            }
            return "User Is Already Registered with this Email Id";
        }
        return "Invalid Email... Please Check";
    }

    public String login(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByEmail(userLoginDTO.getEmail());
        if (user != null) {
            if (user.getPassword().equals(userLoginDTO.getPassword())) {
                return "Welcome " + user.getFirstName() + " " + user.getLastName() + " You are logged in";
            }
        }
        return "Invalid User Credentials";
    }

    public String updatePassword(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByEmail(userLoginDTO.getEmail());
        if(user != null){
            user.setPassword(userLoginDTO.getPassword());
            userRepository.save(user);
            return "Password Updated Successfully";
        }
        return "InValid Email Id";
    }

    public String deleteUser(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByEmail(userLoginDTO.getEmail());
        if(user != null && user.getPassword().equals(userLoginDTO.getPassword())){
            userRepository.delete(user);
            return "Account Deleted Successfully";
        }
        return "No User Is Associated with this userId";
    }


    public String accountDetails(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByEmail(userLoginDTO.getEmail());
        return user.toString();
    }
}
