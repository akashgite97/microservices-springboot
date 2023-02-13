package com.microservices.userService.usermicroservice.services;

import java.util.List;

import com.microservices.userService.usermicroservice.entities.User;

public interface UserService {
    
    User createUser(User user);

    User updateUser(User user, Integer id);

    User getUserById(Integer id);

    List<User> getAllUsers();

    void deleteUser(Integer id);
}
