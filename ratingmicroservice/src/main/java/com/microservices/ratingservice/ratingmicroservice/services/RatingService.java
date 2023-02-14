package com.microservices.ratingservice.ratingmicroservice.services;

import java.util.List;

import com.microservices.ratingservice.ratingmicroservice.entities.Rating;

public interface RatingService {
    
    Rating createRating(Rating rating);

    Rating updateRating(Rating rating, Integer id);

    Rating getRatingById(Integer id);

    List<Rating> getAllRatings();

    void deleteRating(Integer id);

    List<Rating> getRatingsByUserId(String userId);
    
    List<Rating> getRatingsByHotelId(String hotelId);

}
