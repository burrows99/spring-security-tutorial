package com.burrows.springSecurityTutorial.configuration;

import com.burrows.springSecurityTutorial.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home").hasRole("NORMAL")
//                .permitAll() means all types of roles can access
//                to make it role specific we write .hasRole("NORMAL") or .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
//        this will authorize any request that is authenticated and the authentication methiod used will be httpbasic
//        urls inside antmatchers will not be protected by spring security
//        learn about antmatchers
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("john")
//                .password(this.passwordEncoder().encode("password"))
//                .roles("NORMAL");
//        auth
//                .inMemoryAuthentication().
//                withUser("roshni").
//                password(this.passwordEncoder().encode("haha"))
//                .roles("ADMIN");
//    }
//        this method is for creating users during runtime but practically we will pick up users from the database so below method is used.
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

    }

//    this bean is used for encoding the password
    @Bean
    public PasswordEncoder passwordEncoder(){
        return (PasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
