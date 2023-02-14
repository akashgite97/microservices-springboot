package com.microservices.ratingservice.ratingmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.ratingservice.ratingmicroservice.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    // customer find methods
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
