package com.hoteling.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoteling.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{

	List<Booking> findByGid(int id);

}
