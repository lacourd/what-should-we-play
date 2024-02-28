package com.lacourd.whatshouldweplay.controllers;

import com.lacourd.whatshouldweplay.entity.AuthRequest;
import com.lacourd.whatshouldweplay.entity.UserInfo;
import com.lacourd.whatshouldweplay.service.JwtService;
import com.lacourd.whatshouldweplay.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Security tutorials!!";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        return userInfoService.addUser(userInfo);
    }

    @PostMapping("/login")
    public String addUser(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
        if(authenticate.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUserName());
        } else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }

    @GetMapping("/getUsers")
    public List<UserInfo> getAllUsers() {
        return userInfoService.getAllUsers();
    }

    @GetMapping("/getUsers/{id}")
    public UserInfo getUserInfo(@PathVariable Integer id) {
        return userInfoService.getUser(id);
    }
}
