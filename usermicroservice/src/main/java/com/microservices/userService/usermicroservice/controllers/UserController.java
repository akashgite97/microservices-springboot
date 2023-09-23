package com.microservices.userService.usermicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.userService.usermicroservice.entities.User;
import com.microservices.userService.usermicroservice.services.UserService;

@RestController
// @RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/healthCheck")
    public String test() {
        return "working";
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = this.userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User newUser = this.userService.createUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int userId) {

        User updatedUser = this.userService.updateUser(user, userId);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {

        User user = this.userService.getUserById(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {

        this.userService.deleteUser(userId);
    }
}
