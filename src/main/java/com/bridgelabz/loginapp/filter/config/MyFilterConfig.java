/*
@file         :MyFilterConfig.java
@overview     :This Class is configuration filter for the MyFilter Class
@author       :Hrishikesh M Bodake (rishibodake@gmail.com)
@version      :1.0
@since        :20/5/2020
 */
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
