package com.morrisons.supplychain.logistics.transportplanner.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SummaryId implements Serializable{	
	
	 
		private static final long serialVersionUID = 3L;
	 
		@Column(name = "tractor_depot")
		private String tractorDepot;
	 
		@Column(name = "driver_code")
		private String driverCode;
	 
		@Column(name = "shift_date")
		private LocalDate shiftDate;		

}
