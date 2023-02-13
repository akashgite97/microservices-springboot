package com.microservices.userService.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.userService.usermicroservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
