package com.ems.service;

import com.ems.model.Timesheet;
import com.ems.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimesheetServiceImpl implements TimesheetService {
    @Autowired
    TimesheetRepository timesheetRepository;


    @Override
    public Timesheet getTimesheet(int timesheetId) {
        Optional<Timesheet> optionalTimesheet = timesheetRepository.findById(timesheetId);

        return optionalTimesheet.get();
    }

    @Override
    public Timesheet saveTimesheet(Timesheet timesheet) {
        timesheetRepository.save(timesheet);
        return timesheet;
    }


    @Override
    public void deleteTimesheet(int timesheetId) {
        timesheetRepository.deleteById(timesheetId);
    }


    @Override
    public void updateTimesheet(Timesheet timesheet) {
        timesheetRepository.save(timesheet);
    }

}
