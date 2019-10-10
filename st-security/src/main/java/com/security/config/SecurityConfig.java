package com.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置不需要登录验证
//        http.authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .logout()
//                .and()
//                .formLogin()
//                .permitAll();

//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();

        http.authorizeRequests()
                .antMatchers("/*")
                .authenticated()
                .and()
                .formLogin() // Form
        // 登录 激活登录页面/登录动作
        ;
    }
}
