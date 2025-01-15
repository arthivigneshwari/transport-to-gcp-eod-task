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
import com.morrisons.supplychain.logistics.transportplanner.entity.Shift_Summary_Exclusion_Inclusions;
import com.morrisons.supplychain.logistics.transportplanner.repository.Shift_Summary_Exclusion_Inclusions_Repository;

import jakarta.persistence.Entity;

@Service
public class Shift_Summary_Exclusion_Service {

	@Autowired
	private Shift_Summary_Exclusion_Inclusions_Repository repository;

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

		List<Shift_Summary_Exclusion_Inclusions> entities = repository.findAll();
		// findByShiftDate(LocalDate.now());

		String outputCSVFile = ApplicationConstants.Common.CSV_OUTPUT_FILE_LOCATION_SHIFT_SUMMARY_EXCLUSION;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCSVFile))) {

			// write column header
			writer.write(ApplicationConstants.Common.columnHeaders_SHIFT_SUMMARY_EXCLUSION);
			writer.newLine();

			// write data
			for (int i = 0; i < entities.size(); i++) {

				Shift_Summary_Exclusion_Inclusions entity = entities.get(i);

				writer.write(handleNull(entity.getTractorHomebase()) + ","
						+ handleNull(entity.getId().getTractorDepot()) + ","
						+ handleNull(entity.getId().getShiftDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ","
						+ handleNull(entity.getDayOfWeek()) + "," + handleNull(entity.getShiftCount()) + ","
						+ handleNull(entity.getShiftLength()) + "," + handleNull(entity.getPaidHours()) + ","
						+ handleNull(entity.getWorkingTime()) + "," + handleNull(entity.getBreaks()) + ","
						+ handleNull(entity.getPoa()) + "," + handleNull(entity.getLeadInTime()) + ","
						+ handleNull(entity.getDrivingTime()) + "," + handleNull(entity.getOnSiteTime()) + ","
						+ handleNull(entity.getInterPlanTime()) + "," + handleNull(entity.getLeadOutTime()) + ","
						+ handleNull(entity.getId().getTotalOrAverage())+ ","
						+ handleNull(entity.getId().getShiftDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

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
