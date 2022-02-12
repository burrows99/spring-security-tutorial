package com.burrows.springSecurityTutorial.controller;

import com.burrows.springSecurityTutorial.model.User;
import com.burrows.springSecurityTutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {

    @Autowired
    private UserService userService;

//    @PreAuthorize("hasRole('ADMIN") This is the alternate way of granting access to different types of users. Wriiten of contoller class or method of controller class
//    Also @EnableGlobalMethodSecurity(prePostEnabled=true) annotation is used above the configuration class for this method of granting access to specific roles.
    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
}