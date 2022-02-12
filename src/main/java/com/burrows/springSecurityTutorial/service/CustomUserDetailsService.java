package com.burrows.springSecurityTutorial.service;

import com.burrows.springSecurityTutorial.model.CustomUserDetails;
import com.burrows.springSecurityTutorial.model.User;
import com.burrows.springSecurityTutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getById(username);
        if(user == null){
            throw new UsernameNotFoundException("NO USER");
        }
        return new CustomUserDetails(user);
    }
}
