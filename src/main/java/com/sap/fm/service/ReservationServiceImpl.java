package com.sap.fm.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sap.fm.data.BookingData;
import com.sap.fm.data.FlightData;
import com.sap.fm.data.FlightScheduleData;
import com.sap.fm.entity.Airline;
import com.sap.fm.entity.Airport;
import com.sap.fm.entity.Booking;
import com.sap.fm.entity.Customer;
import com.sap.fm.entity.Flight;
import com.sap.fm.entity.FlightSchedule;
import com.sap.fm.entity.Seat;
import com.sap.fm.exception.FlightNotFoundException;
import com.sap.fm.repository.AirPortRepository;
import com.sap.fm.repository.AirlineRepository;
import com.sap.fm.repository.CustomerRepository;
import com.sap.fm.repository.FlightRepository;
import com.sap.fm.repository.FlightReservationRepository;
import com.sap.fm.repository.FlightScheduleRepository;
import com.sap.fm.repository.SeatRepository;
import com.sap.fm.util.Dateutil;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	SeatRepository seatRepository;

	@Autowired
	AirlineRepository airlineRepository;

	@Autowired
	AirPortRepository airPortRepository;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	FlightScheduleRepository flightScheduleRepository;

	@Autowired
	FlightReservationRepository flightReservationRepository;

	@Override
	public void addAirport(Airport airport) {
		airPortRepository.save(airport);

	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public void addSeat(Seat seat) {
		seatRepository.save(seat);

	}

	@Override
	public void addFlight(FlightData flightData) {
		if (flightData == null) {
			return;
		}
		createFlightInfo(flightData);

	}

	private Flight createFlightInfo(FlightData flightData) {
		Optional<List<Airline>> findByAirlineName = airlineRepository.findByAirlineName(flightData.getAirline().getAirlineName());
		Airline airline = null;
		if(findByAirlineName.isEmpty() || CollectionUtils.isEmpty(findByAirlineName.get())) {
			airline = Airline.builder().airlineName(flightData.getAirline().getAirlineName()).build();
			airlineRepository.save(airline);
		}else {
			airline = findByAirlineName.get().stream().findFirst().get();
		}
		

		Airport aiportArrival = Airport.builder().airportName(flightData.getArrival().getAirportName())
				.location(flightData.getArrival().getLocation()).build();
		airPortRepository.save(aiportArrival);

		Airport aiportDeparture = Airport.builder().airportName(flightData.getDeparture().getAirportName())
				.location(flightData.getDeparture().getLocation()).build();
		airPortRepository.save(aiportDeparture);

		// flightData.getSeats().stream().map(seat->seatRepository.save(seat)).collect(Collectors.toList());

		Flight flight = Flight.builder().airline(airline).arrival(aiportArrival).departure(aiportDeparture)
				.flightNo(flightData.getFlightNo()).seats(flightData.getSeats()).build();
		return flightRepository.save(flight);
	}
	
	@Override
	public void addFlightSchedule(FlightScheduleData scheduleData) {
		createFlightSchedule(scheduleData);
	}

	private FlightSchedule createFlightSchedule(FlightScheduleData scheduleData) {
		FlightSchedule schedule = FlightSchedule.builder()
				.departureTime(Dateutil.getTime(scheduleData.getDepartureTime())).status("ON_TIME")
				.gate(scheduleData.getGate()).flight(createFlightInfo(scheduleData.getFlight())).build();
		FlightSchedule savedEntity = flightScheduleRepository.save(schedule);
		return savedEntity;
	}

	@Override
	public void addFlightReservation(BookingData reserveData) {
		if (reserveData == null) {
			return;
		}
		Booking booking = Booking.builder().flightSchedule(createFlightSchedule(reserveData.getFlightScheduleData()))
				.customer(customerRepository.save(reserveData.getCustomer())).pnr(UUID.randomUUID().toString())
				.reservationStatus("Confirmed").reserveTime(Dateutil.getTime(reserveData.getReserveTime())).build();

		flightReservationRepository.saveAndFlush(booking);

	}

	@Override
	public void addFlightSchedlued(FlightSchedule schedule) {
		flightScheduleRepository.save(schedule);

	}

	@Override
	public void addFlightResevration(Booking reservation) {
		flightReservationRepository.save(reservation);

	}

	@Override
	public void addAirline(Airline airline) {
		airlineRepository.save(airline);

	}

	@Override
	public Flight getFlight(String flightNo) throws FlightNotFoundException {
		Optional<Flight> flight = flightRepository.findByFlightNo(flightNo);
		if (flight.isPresent()) {
			return flight.get();
		} else
			throw new FlightNotFoundException("Flight Not found with flightNo :" + flightNo);

	}

	@Override
	public Booking getReservationByPnr(String pnr) {
		return flightReservationRepository.findByPnr(pnr);
	}

	@Override
	public Booking getReservationBycustId(String custId) {
		return flightReservationRepository.findByCustomerCustomerId(Long.valueOf(custId));
	}

	@Override
	public List<Flight> getFlightsByAirportId(String id) {
		// flightRepository.findByArrivalId(id);
		return null;
	}

	

}
