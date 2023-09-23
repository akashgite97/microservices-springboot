package com.microservices.ratingservice.ratingmicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ratingservice.ratingmicroservice.entities.Rating;
import com.microservices.ratingservice.ratingmicroservice.services.RatingService;

@RestController
// @RequestMapping("/api/rating")
public class RatingsController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/healthCheck")
    public String test() {
        return "working";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getAllRatings() {

        List<Rating> ratings = this.ratingService.getAllRatings();

        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating ratings) {

        Rating newRating = this.ratingService.createRating(ratings);

        return new ResponseEntity<>(newRating, HttpStatus.CREATED);
    }

    @PutMapping("/update/{ratingId}")
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating, @PathVariable int ratingId) {

        Rating updatedRating = this.ratingService.updateRating(rating, ratingId);

        return new ResponseEntity<>(updatedRating, HttpStatus.OK);
    }

    @GetMapping("/get/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable int ratingId) {

        Rating rating = this.ratingService.getRatingById(ratingId);

        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ratingId}")
    public void deleteRating(@PathVariable int ratingId) {

        this.ratingService.deleteRating(ratingId);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {

        List<Rating> ratings = this.ratingService.getRatingsByUserId(userId);

        return new ResponseEntity<>(ratings, HttpStatus.CREATED);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {

        List<Rating> ratings = this.ratingService.getRatingsByHotelId(hotelId);

        return new ResponseEntity<>(ratings, HttpStatus.CREATED);
    }


}
