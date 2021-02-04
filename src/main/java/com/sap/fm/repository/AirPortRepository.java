package com.sap.fm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.fm.entity.Airport;

@Repository
public interface AirPortRepository extends JpaRepository<Airport, Integer>{

}
