package com.hoteling.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteling.model.Guest;
import com.hoteling.repository.GuestRepository;
import com.hoteling.util.Status;

@Service
public class GuestService {
	
	@Autowired
	private GuestRepository gr;
	
	
	public static String calAge(String dob) {
		
		LocalDate startDate = LocalDate.parse(dob);;
		LocalDate endDate = LocalDate.now();
		System.out.println(startDate);
		int period = Period.between(startDate, endDate).getYears();
		String calage = Integer.toString(period);
		return calage;
		
	}
	
	public static String getCurrentDate() {
		LocalDate ld = LocalDate.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedString = ld.format(formatter);
		
		return formattedString;
	}
	
	public HashMap<String, Object> saveGuest(Guest guest) {
     
        
			Guest lt=new Guest();
			
			String age_ = GuestService.calAge(guest.getDob());
			
			Status st = new Status();
			st.setErrMsg(null);
			st.setStatus("success");
			st.setStatusCode("200");
			
			lt.setAge(age_);
			lt.setDob(guest.getDob());
			lt.setFirstName(guest.getFirstName());
			lt.setGender(guest.getGender());
			lt.setGid(guest.getGid());
			lt.setLastName(guest.getLastName());
			lt.setLocaldate(GuestService.getCurrentDate());
			lt.setPhone(guest.getPhone());
			
			try {
				lt= gr.save(lt);
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
    
	
	public HashMap<String, Object> gatAllGuests() {
		List<Guest> lt = new ArrayList<Guest>();
		
		Status st = new Status();
		st.setErrMsg(null);
		st.setStatus("success");
		st.setStatusCode("200");
		
		try {
			lt= gr.findAll();
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
