package com.morrisons.supplychain.logistics.transportplanner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shiftDetail")
public class ShiftDetail {

	@EmbeddedId
	private ShiftDetailId shiftDetailId;

	@Column(name = "tractorhomebase")
	private String tractorHomebase;

	@Column(name = "drivername")
	private String driverName;

	@Column(name = "shiftstarttime")
	private LocalDateTime shiftStartTime;

	@Column(name = "shiftendtime")
	private LocalDateTime shiftEndTime;

	@Column(name = "suppliercode")
	private String supplierCode;

	@Column(name = "suffix")
	private String suffix;

	@Column(name = "lateloadtiming")
	private String lateloadflag;

	@Column(name = "customer")
	private String customer;

	@Column(name = "collectionref")
	private String collectionRef;

	@Column(name = "customerref")
	private String customerRef;

	@Column(name = "originaldepot")
	private String originalDepot;

	@Column(name = "originaljob")
	private String originalJob;

	@Column(name = "haulagedepot")
	private String haulageDepot;

	@Column(name = "haulagejob")
	private String haulageJob;

	@Column(name = "planneddepotdeparture")
	private LocalDateTime plannedDepotDeparture;

	@Column(name = "departurelocation")
	private String departureLocation;

	@Column(name = "departuretown")
	private String departureTown;

	@Column(name = "arrivallocation")
	private String arrivalLocation;

	@Column(name = "arrivaltown")
	private String arrivalTown;

	@Column(name = "haulageleg")
	private String haulageLeg;

	@Column(name = "legdistancekm")
	private double legDistanceKm;

	@Column(name = "loadedempty")
	private String loadedEmpty;

	@Column(name = "tractorcode")
	private String tractorCode;

	@Column(name = "tractorcontrollingdepotcode")
	private String tractorControllingDepotCode;

	@Override
	public String toString() {

		return "ShiftDetails [ShiftDetailId=" + shiftDetailId + ", tractorDepot=" + shiftDetailId.getTractorDepot() + ", driverName="
				+ driverName + ", shiftStartTime=" + shiftStartTime + ", shiftEndTime=" + shiftEndTime
				+ ", supplierCode=" + supplierCode + ", suffix=" + suffix + ", lateloadtiming=" + lateloadflag
				+ ", customer=" + customer + ", collectionRef=" + collectionRef + ", customerRef=" + customerRef
				+ ", originalDepot=" + originalDepot + ", originalJob=" + originalJob + ", haulageDepot=" + haulageDepot
				+ ", haulageJob=" + haulageJob + ", plannedDepotDeparture=" + plannedDepotDeparture
				+ ", departureTimestamp=" + shiftDetailId.getDepartureTimestamp() + ", arrivalTimestamp=" + shiftDetailId.getArrivalTimestamp()
				+ ", haulageLeg=" + haulageLeg + ", legDistanceKm=" + legDistanceKm + ", loadedEmpty=" + loadedEmpty
				+ ", tractorCode=" + tractorCode + ", tractorControllingDepotCode=" + tractorControllingDepotCode + "]";
	}

}
