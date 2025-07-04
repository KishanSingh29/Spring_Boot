package com.BackendX.journalApp.controller;

import com.BackendX.journalApp.service.UserService;
import com.BackendX.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;
    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";

    }
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user ){
        userService.saveNewUser(user);
    }

}
