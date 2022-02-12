package com.burrows.springSecurityTutorial.service;

import com.burrows.springSecurityTutorial.model.User;
import com.burrows.springSecurityTutorial.repository.UserRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
//    List<User> list = new ArrayList<>();
//
//    public UserService(){
//        list.add(new User("abc","abc","abc@gmail.com"));
//        list.add(new User("def","def","def@gmail.com"));
//        list.add(new User("ghi","ghi","ghi@gmail.com"));
//    }

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
//        return this.list;
        return this.userRepository.findAll();
    }

    public User getUser(Long id){
//        return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
        return (User) this.userRepository.getById(id);
    }

    public User addUser(User user){
//        this.list.add(user);
//        return user;
        return (User) this.userRepository.save(user);
    }
}
