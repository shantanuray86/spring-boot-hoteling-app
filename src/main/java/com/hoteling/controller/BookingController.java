package com.hoteling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoteling.model.Booking;
import com.hoteling.service.BookingService;
import com.hoteling.service.UtilService;


@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingService bs;
	
	@Autowired
	UtilService us;
	
	@PostMapping("/add")
    public ResponseEntity<Object> addBooking(@RequestBody Booking booking) {
        return new ResponseEntity(bs.saveBooking(booking), HttpStatus.OK);
    }
	
	@PostMapping("/all")
    public ResponseEntity<Object> allBookings() {
        return new ResponseEntity(bs.gatAllBookings(), HttpStatus.OK);
    }

	@PostMapping("/allBookings/{gid}")
    public ResponseEntity<Object> allbookingsGID(@PathVariable("gid") int gid) {
        return new ResponseEntity(us.allRoomPerGuest(gid), HttpStatus.OK);
    }
	
	@PostMapping("/allBookings")
    public ResponseEntity<Object> allbookings() {
        return new ResponseEntity(us.bookingHistoryPerGuest(), HttpStatus.OK);
    }
	
	@PostMapping("/allYoungGuests")
    public ResponseEntity<Object> allYoungGuests() {
        return new ResponseEntity(us.allYoungGuest(), HttpStatus.OK);
    }
}
