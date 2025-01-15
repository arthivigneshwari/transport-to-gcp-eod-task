package com.morrisons.supplychain.logistics.transportplanner.entity;

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
public class Shift_Summary_Exclusion_Inclusions_Id {
	
	private static final long serialVersionUID = 4L;
 
	
	@Column(name = "tractor_depot")
	private String tractorDepot;
	
	@Column(name = "shift_date")
	private LocalDate shiftDate;
	
	@Column(name = "total_or_average")
	private String totalOrAverage;
	
	@Column(name = "inclusion_exclusion")
	private String inclusionExclusion;


}
