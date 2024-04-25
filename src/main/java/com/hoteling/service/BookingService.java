package com.hoteling.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteling.model.Booking;
import com.hoteling.repository.BookingRepository;
import com.hoteling.util.Status;


@Service
public class BookingService {

	@Autowired
	private BookingRepository br;
	
	public HashMap<String, Object> saveBooking(Booking booking) {
     
        
			Booking lt = null;
			
			Status st = new Status();
			st.setErrMsg(null);
			st.setStatus("success");
			st.setStatusCode("200");
			
			try {
				lt= br.save(booking);
			}catch(Exception e) {
				System.out.println(e);
				st.setErrMsg("Something went wrong!" + e);
				st.setStatus("error");
				st.setStatusCode("200");
			}
	
			HashMap<String, Object> finalObj = new HashMap<>();
			finalObj.put("status", st);
			finalObj.put("data",lt);
	        return finalObj;
	   }
    
	
	public HashMap<String, Object> gatAllBookings() {
		List<Booking> lt = new ArrayList<Booking>();
		
		Status st = new Status();
		st.setErrMsg(null);
		st.setStatus("success");
		st.setStatusCode("200");
		
		try {
			lt= br.findAll();
		}catch(Exception e) {
			System.out.println(e);
			st.setErrMsg("Something went wrong!" + e);
			st.setStatus("error");
			st.setStatusCode("200");
		}

		HashMap<String, Object> finalObj = new HashMap<>();
		finalObj.put("status", st);
		finalObj.put("data",lt);
        return finalObj;
    }


}
