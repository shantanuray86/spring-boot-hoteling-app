package com.hoteling.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteling.model.Room;
import com.hoteling.repository.RoomRepository;
import com.hoteling.util.Status;

@Service()
public class RoomService {
	
	@Autowired
	private RoomRepository rr;
	
	public Room saveRoom(Room room) {
        return rr.save(room);
    }
	
	public HashMap<String, Object> gatAllRooms() {
		List<Room> lt = new ArrayList<Room>();
		
		Status st = new Status();
		st.setErrMsg(null);
		st.setStatus("success");
		st.setStatusCode("200");
		
		try {
			lt= rr.findAll();
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
