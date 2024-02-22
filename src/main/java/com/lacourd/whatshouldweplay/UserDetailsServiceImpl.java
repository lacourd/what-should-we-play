package com.lacourd.whatshouldweplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
////    private UserRepository userRepository;
////
////    @Autowired
////    public UserDetailsServiceImpl(UserRepository userRepository) {
////        this.userRepository = userRepository;
////    }
////
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User u = userRepository.findByUsername(username);
////        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), new ArrayList<>());
////    }
//}
