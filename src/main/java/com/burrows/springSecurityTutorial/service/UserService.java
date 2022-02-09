package com.burrows.springSecurityTutorial.service;

import com.burrows.springSecurityTutorial.model.User;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> list = new ArrayList<>();

    public UserService(){
        list.add(new User("abc","abc","abc@gmail.com"));
        list.add(new User("def","def","def@gmail.com"));
        list.add(new User("ghi","ghi","ghi@gmail.com"));
    }

    public List<User> getAllUsers(){
        return this.list;
    }

    public User getUser(String username){
        return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
