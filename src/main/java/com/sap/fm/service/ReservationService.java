package com.sap.fm.service;

import com.sap.fm.data.FlightData;

import java.util.List;

import com.sap.fm.data.BookingData;
import com.sap.fm.data.FlightScheduleData;
import com.sap.fm.entity.Airline;
import com.sap.fm.entity.Airport;
import com.sap.fm.entity.Booking;
import com.sap.fm.entity.Customer;
import com.sap.fm.entity.Flight;
import com.sap.fm.entity.FlightSchedule;
import com.sap.fm.entity.Seat;
import com.sap.fm.exception.FlightNotFoundException;

public interface ReservationService {
	
	void addAirport(Airport airport);
	
	void addSeat(Seat seat);
	
	void addFlight(FlightData flight);
	
	void addFlightSchedlued(FlightSchedule schedule);
	
	void addFlightResevration(Booking reservation);

	void addAirline(Airline airline);

	void addCustomer(Customer customer);

	Flight getFlight(String flightNo) throws FlightNotFoundException;

	void addFlightSchedule(FlightScheduleData scheduleData);

	void addFlightReservation(BookingData reserveData);

	Booking getReservationByPnr(String pnr);

	Booking getReservationBycustId(String pnr);

	List<Flight> getFlightsByAirportId(String id);

}
