package com.morrisons.supplychain.logistics.transportplanner.constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ApplicationConstants {

	public static class Common {

		public static final String CSV_OUTPUT_FILE_LOCATION_DRIVER_SUMMARY = "src/main/resources/gcp/pending/TransportPlanner_ESL_Driver_Summary_"
				+ LocalDate.now().minusDays(1) + ".csv";

		public static final String CSV_OUTPUT_FILE_LOCATION_SHIFT_DETAIL = "src/main/resources/gcp/pending/TransportPlanner_ESL_ShiftDetail_"
				+ LocalDate.now().minusDays(1) + ".csv";

		public static final String CSV_OUTPUT_FILE_LOCATION_EXCLUDED_SHIFTS = "src/main/resources/gcp/pending/TransportPlanner_ESL_Excluded_Shifts_"
				+ LocalDate.now().minusDays(1) + ".csv";

		public static final String CSV_OUTPUT_FILE_LOCATION_SHIFT_SUMMARY_EXCLUSION = "src/main/resources/gcp/pending/TransportPlanner_ESL_Shift_Summary_Exclusion_"
				+ LocalDate.now().minusDays(1) + ".csv";

		public static final String CSV_OUTPUT_FILE_LOCATION_SHIFT_SUMMARY_INCLUSION = "src/main/resources/gcp/pending/TransportPlanner_ESL_Shift_Summary_Inclusion_"
				+ LocalDate.now().minusDays(1) + ".csv";

		public static final String columnHeaders_DRIVER_SUMMARY = "tractor_homebase,tractor_depot,driver_code,shift_date,"
				+ "driver_name,driver_type,shift_length,paid_hours,"
				+ "working_time,breaks,poa,lead_in_time,driving_time," + "on_site_time,inter_plan_time,lead_out_time,stobart_feed_file_date";

		public static final String columnHeaders_SHIFT_DETAIL = "tractor_homebase,tractor_depot,shift_date,driver_name,shift_start_time,shift_end_time,"
				+ "supplier_code,suffix,late_load_flag,customer,collection_ref,customer_ref,driver_code,original_depot,original_job,"
				+ "haulage_depot,haulage_job,planned_depot_departure,departure_location,departure_town,departure_timestamp,"
				+ "arrival_location,arrival_town,arrival_timestamp,haulage_leg,leg_distance_km,loaded_empty,tractor_code,"
				+ "tractor_controlling_depot_code,stobart_feed_file_date";

		public static final String columnHeaders_EXCLUDED_SHIFTS = "tractor_homebase,tractor_depot,driver_code,shift_date,"
				+ "driver_name,driver_type,shift_length,paid_hours,"
				+ "working_time,breaks,poa,lead_in_time,driving_time,"
				+ "on_site_time,inter_plan_time,lead_out_time,late_load_flag(Shift),Exclusion Reason,stobart_feed_file_date";

		public static final String columnHeaders_SHIFT_SUMMARY_EXCLUSION = "tractor_homebase,tractor_depot,shift_date,"
				+ "day_of_week,shift_count,shift_length,paid_hours,"
				+ "working_time,breaks,poa,lead_in_time,driving_time,"
				+ "on_site_time,inter_plan_time,lead_out_time,"
				+ "total_Or_Average,stobart_feed_file_date";

		private Common() {

		}
	}

}
