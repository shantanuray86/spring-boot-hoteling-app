package com.hoteling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteling.model.Guest;
import com.hoteling.model.Room;
import com.hoteling.service.GuestService;



@RestController
@RequestMapping("/guest")
public class GuestController {
	
	@Autowired
	GuestService gs;
	
	@PostMapping("/add")
    public ResponseEntity<Object> addGuest(@RequestBody Guest guest) {
        return new ResponseEntity(gs.saveGuest(guest), HttpStatus.OK);
    }
	
	@PostMapping("/all")
    public ResponseEntity<Object> allGuests() {
        return new ResponseEntity(gs.gatAllGuests(), HttpStatus.OK);
    }

}
