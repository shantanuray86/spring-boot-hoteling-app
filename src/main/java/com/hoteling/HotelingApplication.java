package com.hoteling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hoteling.model.Room;
import com.hoteling.model.RoomTypes;

@SpringBootApplication
public class HotelingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelingApplication.class, args);
		
		
		List list = new ArrayList<>();
		
		    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    RoomTypes roomty;
		  
		    System.out.println("Enter room id");

		    String roomid = myObj.nextLine();  // Read user input
		    System.out.println("Enter room type");
		    try {
		    	 roomty = RoomTypes.valueOf((String) myObj.nextLine());  // Read user input
		    }catch(Exception e) {
		    	System.out.println("Types accepted are :- SMALL,LARGE,SUITE");
		    	System.out.println("Enter room type");
		    	 roomty = RoomTypes.valueOf((String) myObj.nextLine());
		    }
		    
		    System.out.println("Enter room availability");
		    Boolean roomavail = Boolean.valueOf((myObj.nextLine()));
		    
		    int rmid = Integer.parseInt(roomid);
		    
		    Room rm = new Room(rmid,roomty,roomavail);
		    
		list.add(rm);
		System.out.println(list);
		
		
	}

}
