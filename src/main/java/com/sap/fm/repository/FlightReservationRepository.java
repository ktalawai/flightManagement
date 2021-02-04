package com.sap.fm.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.fm.entity.Booking;

@Repository
public interface FlightReservationRepository extends JpaRepository<Booking, BigInteger>{

	Booking findByPnr(String pnr);

	Booking findByCustomerCustomerId(Long valueOf);

}
