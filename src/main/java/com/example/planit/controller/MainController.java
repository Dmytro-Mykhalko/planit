package com.example.planit.controller;

import com.example.planit.entity.UserEntity;
import com.example.planit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

}
