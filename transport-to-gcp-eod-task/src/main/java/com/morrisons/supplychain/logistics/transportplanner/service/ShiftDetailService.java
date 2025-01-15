package com.morrisons.supplychain.logistics.transportplanner.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morrisons.supplychain.logistics.transportplanner.constants.ApplicationConstants;
import com.morrisons.supplychain.logistics.transportplanner.entity.ShiftDetail;
import com.morrisons.supplychain.logistics.transportplanner.repository.ShiftDetailRepository;

@Service
public class ShiftDetailService {

	@Autowired
	private ShiftDetailRepository repository;
	
	public String handleNull(String value) {
		return value == null ? "" : value;
	}
	
	public String handleNull(LocalDateTime value, DateTimeFormatter formatter) {
		return value == null? "":value.format(formatter);
	}
	
	public String handleNull(LocalDate value, DateTimeFormatter formatter) {
		return value == null? "":value.format(formatter);
	}

	public String exportDataToCSV() {

		List<ShiftDetail> entities = repository.findAll();

		String outputCSVFile = ApplicationConstants.Common.CSV_OUTPUT_FILE_LOCATION_SHIFT_DETAIL;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCSVFile))) {

			// write column header
			writer.write(ApplicationConstants.Common.columnHeaders_SHIFT_DETAIL);
			writer.newLine();

			// write data
			for (int i = 0; i < entities.size(); i++) {
				ShiftDetail entity = entities.get(i);

				writer.write(handleNull(entity.getTractorHomebase()) + "," + handleNull(entity.getShiftDetailId().getTractorDepot()) + ","
						+ handleNull(entity.getShiftDetailId().getShiftDate(),DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "," + handleNull(entity.getDriverName()) + ","
						+ handleNull(entity.getShiftStartTime(),DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "," + handleNull(entity.getShiftEndTime(),DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "," + handleNull(entity.getSupplierCode())
						+ "," + handleNull(entity.getSuffix()) + "," + handleNull(entity.getLateloadflag()) + "," + handleNull(entity.getCustomer()) + ","
						+ handleNull(entity.getCollectionRef()) + "," + handleNull(entity.getCustomerRef()) + ","
						+ handleNull(entity.getShiftDetailId().getDriverCode()) + "," + handleNull(entity.getOriginalDepot()) + ","
						+ handleNull(entity.getOriginalJob()) + "," + handleNull(entity.getHaulageDepot()) + "," + handleNull(entity.getHaulageJob()) + ","
						+ handleNull(entity.getPlannedDepotDeparture(),DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "," + handleNull(entity.getDepartureLocation()) + ","
						+ handleNull(entity.getDepartureTown()) + "," + handleNull(entity.getShiftDetailId().getDepartureTimestamp(),DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))+","
						+ handleNull(entity.getArrivalLocation()) + "," + handleNull(entity.getArrivalTown()) + ","
						+ handleNull(entity.getShiftDetailId().getArrivalTimestamp(),DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "," + handleNull(entity.getHaulageLeg()) + ","
						+ handleNull(Double.toString(entity.getLegDistanceKm())) + "," + handleNull(entity.getLoadedEmpty()) + "," + handleNull(entity.getTractorCode())
						+ "," + handleNull(entity.getTractorControllingDepotCode())
						+"," +handleNull(entity.getShiftDetailId().getShiftDate(),DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				if (i < entities.size() - 1) {
					writer.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "CSV file exported successfully";
	}

}
