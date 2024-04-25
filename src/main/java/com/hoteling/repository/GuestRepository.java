package com.hoteling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteling.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer>{

	Guest findByGid(int gid);

}
