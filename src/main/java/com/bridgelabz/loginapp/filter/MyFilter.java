package com.bridgelabz.loginapp.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Scanner;

@Component
public class MyFilter implements Filter {
    Scanner scan = new Scanner(System.in);
    String password = "password";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("You Need Admin Privileges to access this field");
        System.out.println("Please Enter Admin Password");
        String pass = scan.nextLine();
        if(pass.equals(password)){
            chain.doFilter(request,response);
        }


    }
}
