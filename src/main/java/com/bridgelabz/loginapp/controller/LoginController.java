package com.bridgelabz.loginapp.controller;

import com.bridgelabz.loginapp.dto.UserLoginDTO;
import com.bridgelabz.loginapp.entity.User;
import com.bridgelabz.loginapp.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginAndRegisterService loginAndRegisterService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return loginAndRegisterService.register(user);
    }


    @PostMapping("/login")
    public String loginUser(@RequestBody UserLoginDTO userLoginDTO){
        return loginAndRegisterService.login(userLoginDTO);
    }

    @PostMapping("/forgot")
    public String forgotPassword(@RequestBody UserLoginDTO userLoginDTO){
        return loginAndRegisterService.updatePassword(userLoginDTO);
    }

}

