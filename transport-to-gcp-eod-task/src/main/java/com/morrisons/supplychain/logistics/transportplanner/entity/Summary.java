package com.morrisons.supplychain.logistics.transportplanner.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name = "summary")
@Table(schema = "transportplanner",name = "driver_shift_summary")
public class Summary {

	@Column(name = "tractor_homebase")
	private String tractorHomebase;

	@EmbeddedId
	private SummaryId summaryId;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "driver_type")
	private String driverType;

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
	private LocalDateTime createdTimeStamp;

}
