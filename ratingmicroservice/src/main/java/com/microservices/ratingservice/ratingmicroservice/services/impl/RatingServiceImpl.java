package com.microservices.ratingservice.ratingmicroservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.ratingservice.ratingmicroservice.entities.Rating;
import com.microservices.ratingservice.ratingmicroservice.exceptions.ResourceNotFoundException;
import com.microservices.ratingservice.ratingmicroservice.repository.RatingRepository;
import com.microservices.ratingservice.ratingmicroservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepo;

    @Override
    public Rating createRating(Rating ratings) {

        Rating savedRating = this.ratingRepo.save(ratings);
        return savedRating;
    }

    @Override
    public Rating updateRating(Rating rating, Integer ratingId) {

        rating.setRatingId(rating.getRatingId());
        rating.setHotelId(rating.getHotelId());
        rating.setUserId(rating.getUserId());
        rating.setRatings(rating.getRatings());
        rating.setFeedback(rating.getFeedback());
        rating.setRemark(rating.getRemark());

        Rating updatedRating = this.ratingRepo.save(rating);

        return updatedRating;
    }

    @Override
    public Rating getRatingById(Integer ratingId) {
        Rating Rating = this.ratingRepo.findById(ratingId)
                .orElseThrow(() -> new ResourceNotFoundException("Rating", "ratingId", ratingId));

        return Rating;
    }

    @Override
    public List<Rating> getAllRatings() {

        List<Rating> ratings = this.ratingRepo.findAll();

        return ratings.stream().map(rating -> (rating)).collect(Collectors.toList());

    }

    @Override
    public void deleteRating(Integer ratingId) {
        Rating Rating = this.ratingRepo.findById(ratingId)
                .orElseThrow(() -> new ResourceNotFoundException("Rating", "ratingId", ratingId));

        this.ratingRepo.delete(Rating);
    }

    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
