package com.morrisons.supplychain.logistics.transportplanner.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morrisons.supplychain.logistics.transportplanner.constants.ApplicationConstants;
import com.morrisons.supplychain.logistics.transportplanner.entity.Summary;
import com.morrisons.supplychain.logistics.transportplanner.entity.SummaryId;
import com.morrisons.supplychain.logistics.transportplanner.repository.SummaryRepository;

@Service
public class SummaryFileService {

	@Autowired
	private SummaryRepository repository;
	
	public LocalDate parseDateOrDefault(String inputDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		if(inputDate == null) {
			return LocalDate.now().minusDays(1);
		}
		
		try {
			return LocalDate.parse(inputDate,formatter);
		}catch(NullPointerException  | DateTimeParseException e) {
			System.err.println(" Invalid date format: " +inputDate);
			return LocalDate.now().minusDays(1);
		}
	}

	public String exportDataToCSV(String inputDate) {				
		
		LocalDate date = (inputDate == null)? LocalDate.now().minusDays(1) : LocalDate.parse(inputDate,DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		List<Summary> entities = repository.findBySummaryIdShiftDate(date);

		String outputCSVFile = ApplicationConstants.Common.CSV_OUTPUT_FILE_LOCATION_DRIVER_SUMMARY;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCSVFile))) {

			// write column header
			writer.write(ApplicationConstants.Common.columnHeaders_DRIVER_SUMMARY);
			writer.newLine();

			// write data
			for (int i = 0; i < entities.size(); i++) {
				Summary entity = entities.get(i);
				SummaryId summaryId = entity.getSummaryId();

				writer.write(entity.getTractorHomebase() + "," + summaryId.getTractorDepot() + ","
						+ summaryId.getDriverCode() + "," + summaryId.getShiftDate().toString() + ","
						+ entity.getDriverName() + "," + entity.getDriverType() + "," + entity.getShiftLength() + ","
						+ entity.getPaidHours() + "," + entity.getWorkingTime() + "," + entity.getBreaks() + ","
						+ entity.getPoa() + "," + entity.getLeadInTime() + "," + entity.getDrivingTime() + ","
						+ entity.getOnSiteTime() + "," + entity.getInterPlanTime() + "," + entity.getLeadOutTime() + ","
						+ entity.getSummaryId().getShiftDate());
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
