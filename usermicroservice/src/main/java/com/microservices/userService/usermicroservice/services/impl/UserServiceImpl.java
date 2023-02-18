package com.microservices.userService.usermicroservice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.userService.usermicroservice.entities.Rating;
import com.microservices.userService.usermicroservice.entities.User;
import com.microservices.userService.usermicroservice.exceptions.ResourceNotFoundException;
import com.microservices.userService.usermicroservice.repository.UserRepository;
import com.microservices.userService.usermicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

        // get user ratings form RATING_SERVICE
        ArrayList<Rating> userRatings = restTemplate
                .getForObject("http://localhost:8083/api/rating/users/" + user.getId(), ArrayList.class);
        logger.info("userRatings" + userRatings);

        user.setRatings(userRatings);

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

}
