package com.morrisons.supplychain.logistics.transportplanner.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shift_summary_incl_excl")
public class Shift_Summary_Exclusion_Inclusions extends {
	
	@EmbeddedId
	private Shift_Summary_Exclusion_Inclusions_Id id;
	
	@Column(name = "tractor_homebase")
	private String tractorHomebase;

	@Column(name = "day_of_week")
	private String dayOfWeek;
 
	@Column(name = "shift_count")
	private String shiftCount;
 
	@Column(name = "shift_length")
	private String shiftLength;
 
	@Column(name = "paid_hours")
	private String paidHours;
 
	@Column(name = "working_time")
	private String workingTime;
 
	@Column(name = "breaks")
	private String breaks;
 
	@Column(name = "poa")
	private String poa;
 
	@Column(name = "lead_in_time")
	private String leadInTime;
 
	@Column(name = "driving_time")
	private String drivingTime;
 
	@Column(name = "on_site_time")
	private String onSiteTime;
 
	@Column(name = "inter_plan_time")
	private String interPlanTime;
 
	@Column(name = "lead_out_time")
	private String leadOutTime;
 
	@Column(name = "created_timestamp")
	private LocalDateTime createdTimestamp;
 
}
