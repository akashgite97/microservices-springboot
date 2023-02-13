package com.microservices.hotelservice.hotelmicroservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.hotelservice.hotelmicroservice.entities.Hotel;
import com.microservices.hotelservice.hotelmicroservice.exceptions.ResourceNotFoundException;
import com.microservices.hotelservice.hotelmicroservice.repository.HotelRepository;
import com.microservices.hotelservice.hotelmicroservice.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {

        Hotel savedHotel = this.hotelRepo.save(hotel);
        return savedHotel;
    }

    @Override
    public Hotel updateHotel(Hotel hotel, Integer hotelId) {

        if (hotel.getId() == hotelId) {
            hotel.setName(hotel.getName());
            hotel.setLocation(hotel.getLocation());
            hotel.setAbout(hotel.getAbout());
        }

        Hotel updatedHotel= this.hotelRepo.save(hotel);

        return updatedHotel;
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
        Hotel hotel = this.hotelRepo.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));

        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {

        List<Hotel> hotels = this.hotelRepo.findAll();

        return hotels.stream().map(hotel -> (hotel)).collect(Collectors.toList());

    }

    @Override
    public void deleteHotel(Integer hotelId) {
        Hotel hotel = this.hotelRepo.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));

        this.hotelRepo.delete(hotel);
    }

  

}
