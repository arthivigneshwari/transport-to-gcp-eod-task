package com.morrisons.supplychain.logistics.transportplanner.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ShiftDetailId implements Serializable{
	
	 
		private static final long serialVersionUID = 2L;
	 
		@Column(name = "tractordepot")
		private String tractorDepot;
	 
		@Column(name = "shiftdate")
		private LocalDate shiftDate;
	 
		@Column(name = "drivercode")
		private String driverCode;
		
		@Column(name = "departuretimestamp")
		private LocalDateTime departureTimestamp;
	 
		@Column(name = "arrivaltimestamp")
		private LocalDateTime arrivalTimestamp;

}
