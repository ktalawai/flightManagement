package com.sap.fm.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "flight_booking")
@NoArgsConstructor
public class Booking {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;
     
	 String pnr;
    
     @OneToOne
     FlightSchedule flightSchedule;
     
     LocalDateTime reserveTime;
     
     String reservationStatus;
     
     @OneToOne
     Customer customer;
}
