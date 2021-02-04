package com.sap.fm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.fm.entity.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer>{

	Optional<List<Airline>> findByAirlineName(String airlineName);

}
