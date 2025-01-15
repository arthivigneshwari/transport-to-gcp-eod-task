package com.morrisons.supplychain.logistics.transportplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.morrisons.supplychain.logistics.transportplanner.service.ExcludedShiftsService;
import com.morrisons.supplychain.logistics.transportplanner.service.ShiftDetailService;
import com.morrisons.supplychain.logistics.transportplanner.service.Shift_Summary_Exclusion_Service;
import com.morrisons.supplychain.logistics.transportplanner.service.SummaryFileService;

@SpringBootApplication
public class TransportToGcpEodTaskApplication implements CommandLineRunner {

	@Autowired
	private SummaryFileService service;

	@Autowired
	private ShiftDetailService shiftDetailService;
	
	@Autowired
	private ExcludedShiftsService excludedShiftsService;
	
	@Autowired
	private Shift_Summary_Exclusion_Service shiftSummaryExclusionService; 

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		SpringApplication.run(TransportToGcpEodTaskApplication.class, args);
		long endTime = System.nanoTime();

		long durationInNano = endTime - startTime;

		double durationInMillis = durationInNano / 1_000_000.0; // Convert to milliseconds

		System.out.println("Execution time in nanoseconds: " + durationInNano);
		System.out.println("Execution time in milliseconds: " + durationInMillis);
	}

	@Override
	public void run(String... args) throws Exception {
		//service.exportDataToCSV(LocalDate.parse(null, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		
		service.exportDataToCSV("25-07-2024");
		
		shiftDetailService.exportDataToCSV();
		excludedShiftsService.exportDataToCSV();
		shiftSummaryExclusionService.exportDataToCSV();
	}

}
