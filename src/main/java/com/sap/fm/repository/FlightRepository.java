package com.sap.fm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.fm.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	Optional<Flight> findByFlightNo(String flightNo);

	void findByArrivalId(String id);

}
