package com.hoteling.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity()
public class Room {

	@Id
	int rid;
	RoomTypes type;
	boolean available;
	
	
	public Room(int rid, RoomTypes type, boolean available) {
		super();
		this.rid = rid;
		this.type = type;
		this.available = available;
	}
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public RoomTypes getType() {
		return type;
	}
	public void setType(RoomTypes type) {
		this.type = type;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Room [rid=" + rid + ", type=" + type + ", available=" + available + "]";
	}
	
	
}
