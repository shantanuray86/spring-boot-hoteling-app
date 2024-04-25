package com.hoteling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteling.model.Room;
import com.hoteling.service.RoomService;


@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService rs;
	
	@PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody Room room) {
		System.out.println(room.getType());
		//System.out.println(room.getType());
        return new ResponseEntity(rs.saveRoom(room), HttpStatus.OK);
    }
	
	@PostMapping("/all")
    public ResponseEntity<Object> allRooms() {
        return new ResponseEntity(rs.gatAllRooms(), HttpStatus.OK);
    }
}
