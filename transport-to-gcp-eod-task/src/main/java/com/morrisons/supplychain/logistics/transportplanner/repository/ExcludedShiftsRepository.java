package com.morrisons.supplychain.logistics.transportplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morrisons.supplychain.logistics.transportplanner.entity.ExcludedShifts;
import com.morrisons.supplychain.logistics.transportplanner.entity.ExcludedShiftsId;

public interface ExcludedShiftsRepository  extends JpaRepository<ExcludedShifts, ExcludedShiftsId>{

}
