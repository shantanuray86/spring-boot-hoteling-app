package com.hoteling.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteling.model.Booking;
import com.hoteling.model.Guest;
import com.hoteling.model.Room;
import com.hoteling.repository.BookingRepository;
import com.hoteling.repository.GuestRepository;
import com.hoteling.repository.RoomRepository;
import com.hoteling.util.Status;

@Service
public class UtilService {
	
	@Autowired
	GuestRepository gr;
	
	@Autowired
	RoomRepository rr;
	
	@Autowired
	BookingRepository br;
	
	/** This function receives the guest id as parameter and sends the 
	* Guest details and the room details that he/she has booked
	* @param guest id (gid)
	*/
	
	public  Map<String, Object> allRoomPerGuest(int gid)
	{
		int id_ = gid;
		List<Booking> lb = br.findByGid(id_);
		List<Room> lr = rr.findAll();
				
		Map<String, Object> hm 
	      = new HashMap<String, Object>();
		  
		Room rl =null;
		Guest guestInfo=null;
		
		for(int i=0;i<lb.size();i++) {
			int j = i;
			rl = lr.stream().filter(s->s.getRid()==lb.get(j).getRid()).collect(Collectors.toList()).get(0);
			guestInfo = gr.findByGid(lb.get(j).getGid());
					
		}
		
		hm.put("Room", rl);
		hm.put("Guest", guestInfo);
		
		return hm;
		
		
	}
	
	// Get all the bookings of all the guests(past, present future all bookings)
	
	
	public  List<Object> bookingHistoryPerGuest()
	{
		
		List<Booking> lb = br.findAll();
		List<Room> lr = rr.findAll();
				
		Status st =  new Status();
		  
		Room rl =null;
		Guest guestInfo=null;
		List<Object> allBookings= new ArrayList<Object>();
		
		try {
			
			   for(int i=0;i<lb.size();i++) {
				
				int j = i;
				
				rl = lr.stream().filter(s->s.getRid()==lb.get(j).getRid()).collect(Collectors.toList()).get(0);
				guestInfo = gr.findByGid(lb.get(j).getGid());
				
//				hm.put("gid ", guestInfo.getGid());
//				hm.put("firstName ", guestInfo.getFirstName());
//				hm.put("lastName ", guestInfo.getLastName());
//				hm.put("gender ", guestInfo.getGender());
//				hm.put("age ", guestInfo.getAge());
//				hm.put("phone ", guestInfo.getPhone());
//				hm.put("rid ", rl.getRid());
//				hm.put("type ", rl.getType());
//				hm.put("available ", rl.isAvailable());
				
				// Create the response object
				Map<String, Object> hm = new HashMap<String, Object>();
			   
				// Add the elements in the object
				hm.put("Room", rl);
				hm.put("Guest", guestInfo);
				
				// Add the objects in the list 
				allBookings.add(hm);						
			}
			   st.setErrMsg("nil");
			   st.setStatus("success");
			   st.setStatusCode("200");
			
		}catch(Exception e) {
			 st.setErrMsg(e.getMessage());
			 st.setStatus("error");
			 st.setStatusCode("200");
		}
		
		// Add the status object to the response object
		allBookings.add(st);
		
		return allBookings;
		
		
	}

	
	/** This function provides all the guests who are below 35 years 
	* Guest details and the room details that he/she has booked
	* @param 
	*/
	
	public List<Guest> allYoungGuest()
	{
		
		List<Guest> guests = gr.findAll();
		List<Guest> g_ = new ArrayList<>();
				
		g_ =guests.stream().filter(s->Integer.parseInt(s.getAge())<35)
		.sorted((a1,a2)->a1.getAge().compareTo(a2.getAge()))
		.collect(Collectors.toList());
		
		
		
		return g_;
		
		
	}
}
