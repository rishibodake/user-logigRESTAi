/*
@file         :LoginController.java
@overview     :This Class is users entry point when we hit the url
@author       :Hrishikesh M Bodake (rishibodake@gmail.com)
@version      :1.0
@since        :20/5/2020
 */
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

    @PostMapping("/remove")
    public String deleteUser(@RequestBody UserLoginDTO userLoginDTO){
        return loginAndRegisterService.deleteUser(userLoginDTO);
    }

    @PostMapping("/view")
    public String readUser(@RequestBody UserLoginDTO userLoginDTO){
        return loginAndRegisterService.accountDetails(userLoginDTO);
    }


}

