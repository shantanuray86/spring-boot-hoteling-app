package com.hoteling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoteling.model.Room;


public interface RoomRepository extends JpaRepository<Room,Integer>{

}
