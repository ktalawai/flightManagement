package com.sap.fm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.fm.data.BookingData;
import com.sap.fm.data.FlightData;
import com.sap.fm.data.FlightScheduleData;
import com.sap.fm.entity.Airline;
import com.sap.fm.entity.Airport;
import com.sap.fm.entity.Booking;
import com.sap.fm.entity.Flight;
import com.sap.fm.entity.Seat;
import com.sap.fm.exception.FlightNotFoundException;
import com.sap.fm.service.ReservationService;

@RestController
@RequestMapping("flight")
public class FlightReservationController {
	
	@Autowired
	ReservationService service;

	@PostMapping(value="/seat/add")
	public void addSeat(@RequestBody Seat seat) {
		service.addSeat(seat);
	}
	
	@PostMapping(value="/airline/add")
	public void addAirline(@RequestBody Airline airline) {
		service.addAirline(airline);
	}
	
	@PostMapping(value="/flight/add")
	public void addFlight(@RequestBody FlightData flight) {
		service.addFlight(flight);
	}
	
	@PostMapping(value="/airport/add")
	public void addAirport(@RequestBody Airport airport) {
		service.addAirport(airport);
	}
	
	@PostMapping(value="/schedule/add")
	public void addFlightSchedule(@RequestBody FlightScheduleData scheduleData) {
		service.addFlightSchedule(scheduleData);
	}
	
	@PostMapping(value="/reserve/add")
	public void addFlightReservation(@RequestBody BookingData reserveData) {
		service.addFlightReservation(reserveData);
	}
	
	@GetMapping(value="/flight/{flightNo}")
	public Flight getFlight(@PathVariable("flightNo") String flightNo) throws FlightNotFoundException {
		return service.getFlight(flightNo);
	}
	
	@GetMapping(value="/reserve/{pnr}")
	public Booking getReservationByPnr(@PathVariable("pnr") String pnr) throws FlightNotFoundException {
		return service.getReservationByPnr(pnr);
	}
	
	@GetMapping(value="/reserve/cust/{custId}")
	public Booking getReservationBycustId(@PathVariable("custId") String custId) throws FlightNotFoundException {
		return service.getReservationBycustId(custId);
	}
	
	@GetMapping(value="/flight/airport/{id}")
	public List<Flight> getFlightsByAirportId(@PathVariable("id") String id) throws FlightNotFoundException {
		return service.getFlightsByAirportId(id);
	}
}
