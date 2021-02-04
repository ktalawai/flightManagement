package com.sap.fm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "flight")
@NoArgsConstructor
public class Flight {
	@Id
	String flightNo;
	
	int duration;
	
	@OneToOne
	Airport arrival;
	
	@OneToOne
	Airport departure;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Seat> seats;
	
	@OneToOne
	Airline airline;
}
