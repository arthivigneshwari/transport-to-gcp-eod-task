package com.morrisons.supplychain.logistics.transportplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morrisons.supplychain.logistics.transportplanner.entity.ShiftDetail;
import com.morrisons.supplychain.logistics.transportplanner.entity.ShiftDetailId;

public interface ShiftDetailRepository extends JpaRepository<ShiftDetail, ShiftDetailId> {

}
