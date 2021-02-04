package com.sap.fm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "seat")
@NoArgsConstructor
public class Seat {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
     String seatNo;
     String seatType;
}
