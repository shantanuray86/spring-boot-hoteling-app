package com.hoteling.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id
	int bid;   // booking id
	int gid;  // guest id
	int rid; // room id
	
	public Booking(int bid, int gid, int rid) {
		super();
		this.bid = bid;
		this.gid = gid;
		this.rid = rid;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", gid=" + gid + ", rid=" + rid + "]";
	}
	
	

}
