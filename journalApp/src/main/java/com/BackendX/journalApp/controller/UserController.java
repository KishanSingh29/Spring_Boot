package com.BackendX.journalApp.controller;

import com.BackendX.journalApp.JournalApplication;
import com.BackendX.journalApp.Service.JournalEntryService;
import com.BackendX.journalApp.Service.UserService;
import com.BackendX.journalApp.entity.JournalEntry;
import com.BackendX.journalApp.entity.User;
import com.BackendX.journalApp.repository.JournalEntryRepository;
import com.BackendX.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }












}
