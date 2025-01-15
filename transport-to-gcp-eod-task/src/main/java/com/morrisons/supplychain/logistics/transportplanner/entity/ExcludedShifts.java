package com.morrisons.supplychain.logistics.transportplanner.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "excluded_shifts")
public class ExcludedShifts {

	@EmbeddedId
	private ExcludedShiftsId excludedShiftsId;

	@Column(name = "tractor_homebase")
	private String tractorHomebase;

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

	@Column(name = "late_load_flag_shift")
	private String lateLoadFlagShift;

	@Column(name = "exclusion_reason")
	private String exclusionReason;

	@Column(name = "createdtimestamp")
	private LocalDateTime createdTimeStamp;

}
