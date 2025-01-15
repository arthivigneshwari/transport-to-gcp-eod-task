package com.morrisons.supplychain.logistics.transportplanner.utils;

import java.time.LocalDate;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SQLQueryConstants {
	
	String previousDate = LocalDate.now().minusDays(1).toString();
	
	//public static final String SHIFT_DATE_DRIVER_SHIFT_SUMMARY_QUERY = "select s from Summary s where (inputDate is NULL AND s.id.shiftDate = :previousDate" 
		//	+ "OR (inputDate IS NOT NULL AND shiftDate = inputDate::DATE)";


	//public static final String SHIFT_DATE_QUERY = "select * from Shift_Summary_Exclusion_Inclusions s where s.id.shiftDate = :shiftDate";

}
