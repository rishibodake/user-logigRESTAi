package com.bridgelabz.loginapp.filter.config;

import com.bridgelabz.loginapp.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> registrationBean(){

        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter() );
        registrationBean.addUrlPatterns("/user/remove");
        registrationBean.addUrlPatterns("/user/view");


        return registrationBean;
    }
}
