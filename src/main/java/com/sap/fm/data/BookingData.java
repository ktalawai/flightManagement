package com.sap.fm.data;

import java.math.BigInteger;

import com.sap.fm.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingData {
	BigInteger id;

	String pnr;

	FlightScheduleData flightScheduleData;

	String reserveTime;

	String reservationStatus;

	Customer customer;
}
