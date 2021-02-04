package com.sap.fm.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dateutil {
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	
	public static LocalDateTime getTime(String date) {
		return LocalDateTime.parse(date, formatter);
	}

}
