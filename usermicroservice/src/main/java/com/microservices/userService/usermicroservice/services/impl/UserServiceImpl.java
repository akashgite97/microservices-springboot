package com.microservices.userService.usermicroservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.userService.usermicroservice.entities.User;
import com.microservices.userService.usermicroservice.exceptions.ResourceNotFoundException;
import com.microservices.userService.usermicroservice.repository.UserRepository;
import com.microservices.userService.usermicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User createUser(User user) {

        User savedUser = this.userRepo.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(User user, Integer userId) {

        if (user.getId() == userId) {
            user.setName(user.getName());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setAbout(user.getAbout());
        }

        User updatedUser = this.userRepo.save(user);

        return updatedUser;
    }

    @Override
    public User getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        return user;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = this.userRepo.findAll();

        return users.stream().map(user -> (user)).collect(Collectors.toList());

    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        this.userRepo.delete(user);
    }

    // private User ToUser(User user){

    // User user = new User();

    // user.setId(user.getId());
    // user.setName(user.getName());
    // user.setEmail(user.getEmail());
    // user.setPassword(user.getPassword());
    // user.setAbout(user.getAbout());

    // return user;
    // }

    // private User userToDto(User user){

    // UserDto userDto = new UserDto();

    // userDto.setId(user.getId());
    // userDto.setName(user.getName());
    // userDto.setEmail(user.getEmail());
    // userDto.setPassword(user.getPassword());
    // userDto.setAbout(user.getAbout());

    // return userDto;
    // }

}
