package com.sap.fm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.fm.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>{
	

}
