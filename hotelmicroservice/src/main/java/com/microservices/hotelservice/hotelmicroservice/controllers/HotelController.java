
package com.microservices.hotelservice.hotelmicroservice.controllers;
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

import com.microservices.hotelservice.hotelmicroservice.entities.Hotel;
import com.microservices.hotelservice.hotelmicroservice.services.HotelService;


@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/healthCheck")
    public String test() {
        return "working";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {

        List<Hotel> hotels = this.hotelService.getAllHotels();

        return new ResponseEntity<>(hotels, HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {

        Hotel newHotel = this.hotelService.createHotel(hotel);

        return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
    }

    @PutMapping("/update/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable int hotelId) {

        Hotel updatedHotel = this.hotelService.updateHotel(hotel, hotelId);

        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    @GetMapping("/get/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId) {

        Hotel hotel = this.hotelService.getHotelById(hotelId);

        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{hotelId}")
    public void deleteHotel(@PathVariable int hotelId) {

        this.hotelService.deleteHotel(hotelId);
    }
}
