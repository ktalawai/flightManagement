package com.sap.fm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "airport")
@NoArgsConstructor
public class Airport {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
     String airportName;
     
     String location;
     
     @ManyToMany(fetch = FetchType.LAZY,
             cascade = {
                 CascadeType.PERSIST,
                 CascadeType.MERGE
             })
     @JoinTable(name = "airports_flights",
     joinColumns = { @JoinColumn(name = "id") },
     inverseJoinColumns = { @JoinColumn(name = "flightNo") })
     List<Flight> flightList;
}
