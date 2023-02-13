package com.microservices.hotelservice.hotelmicroservice.services;

import java.util.List;

import com.microservices.hotelservice.hotelmicroservice.entities.Hotel;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    Hotel updateHotel(Hotel hotel, Integer id);

    Hotel getHotelById(Integer id);

    List<Hotel> getAllHotels();

    void deleteHotel(Integer id);
}
