package com.ems.service;

import com.ems.model.Timesheet;

public interface TimesheetService {
    Timesheet getTimesheet(int timesheetId);

    Timesheet saveTimesheet(Timesheet timesheet);

    void deleteTimesheet(int timesheetId);

    void updateTimesheet(Timesheet timesheet);
}
