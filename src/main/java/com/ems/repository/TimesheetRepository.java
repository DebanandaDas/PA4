package com.ems.repository;

import com.ems.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet,Integer> {
}
