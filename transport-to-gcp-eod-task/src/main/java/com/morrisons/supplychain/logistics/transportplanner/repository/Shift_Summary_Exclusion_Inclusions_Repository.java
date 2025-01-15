package com.morrisons.supplychain.logistics.transportplanner.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.morrisons.supplychain.logistics.transportplanner.entity.Shift_Summary_Exclusion_Inclusions;
import com.morrisons.supplychain.logistics.transportplanner.entity.Shift_Summary_Exclusion_Inclusions_Id;
import com.morrisons.supplychain.logistics.transportplanner.utils.SQLQueryConstants;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface Shift_Summary_Exclusion_Inclusions_Repository extends JpaRepository<Shift_Summary_Exclusion_Inclusions, Shift_Summary_Exclusion_Inclusions_Id>{

	/*@Query(SQLQueryConstants.SHIFT_DATE_QUERY)
	List<Shift_Summary_Exclusion_Inclusions> findByShiftDate(@Param("shiftDate") LocalDate shiftDate);*/
	
}
