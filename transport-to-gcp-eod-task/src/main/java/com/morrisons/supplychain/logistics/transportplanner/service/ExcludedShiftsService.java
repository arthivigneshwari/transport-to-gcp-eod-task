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
import com.morrisons.supplychain.logistics.transportplanner.entity.ExcludedShifts;
import com.morrisons.supplychain.logistics.transportplanner.repository.ExcludedShiftsRepository;

@Service
public class ExcludedShiftsService {

	@Autowired
	private ExcludedShiftsRepository repository;

	public String handleNull(String value) {
		return value == null ? "" : value;
	}

	public String handleNull(LocalDateTime value, DateTimeFormatter formatter) {
		return value == null ? "" : value.format(formatter);
	}

	public String handleNull(LocalDate value, DateTimeFormatter formatter) {
		return value == null ? "" : value.format(formatter);
	}

	public String exportDataToCSV() {

		List<ExcludedShifts> entities = repository.findAll();

		String outputCSVFile = ApplicationConstants.Common.CSV_OUTPUT_FILE_LOCATION_EXCLUDED_SHIFTS;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCSVFile))) {

			// write column header
			writer.write(ApplicationConstants.Common.columnHeaders_EXCLUDED_SHIFTS);
			writer.newLine();

			// write data
			for (int i = 0; i < entities.size(); i++) {
				ExcludedShifts entity = entities.get(i);

				writer.write(handleNull(entity.getTractorHomebase()) + ","
						+ handleNull(entity.getExcludedShiftsId().getTractorDepot()) + ","
						+ handleNull(entity.getExcludedShiftsId().getDriverCode()) + ","
						+ handleNull(entity.getExcludedShiftsId().getShiftDate(),
								DateTimeFormatter.ofPattern("dd-MM-yyyy"))
						+ "," + handleNull(entity.getDriverName()) + "," + handleNull(entity.getDriverType()) + ","
						+ handleNull(entity.getShiftLength()) + "," + handleNull(entity.getPaidHours()) + ","
						+ handleNull(entity.getWorkingTime()) + "," + handleNull(entity.getBreaks()) + ","
						+ handleNull(entity.getPoa()) + "," + handleNull(entity.getLeadInTime()) + ","
						+ handleNull(entity.getDrivingTime()) + "," + handleNull(entity.getOnSiteTime()) + ","
						+ handleNull(entity.getInterPlanTime()) + "," + handleNull(entity.getLeadOutTime()) + ","
						+ handleNull(entity.getLateLoadFlagShift()) + ","
						+ handleNull(entity.getExclusionReason()) + ","
						//+ handleNull(entity.getCreatedTimeStamp(), DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm"))
						+ handleNull(entity.getExcludedShiftsId().getShiftDate(),
								DateTimeFormatter.ofPattern("dd-MM-yyyy")));
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
