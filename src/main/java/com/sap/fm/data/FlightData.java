package com.sap.fm.data;

import java.util.List;

import com.sap.fm.entity.Airline;
import com.sap.fm.entity.Airport;
import com.sap.fm.entity.Seat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightData {
	String flightNo;

	int duration;

	Airport arrival;

	Airport departure;

	List<Seat> seats;

	Airline airline;
}
