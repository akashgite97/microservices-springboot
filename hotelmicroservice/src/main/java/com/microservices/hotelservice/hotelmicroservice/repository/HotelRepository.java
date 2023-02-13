package com.microservices.hotelservice.hotelmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.hotelservice.hotelmicroservice.entities.Hotel;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {


}
