package com.ems.controller;

import com.ems.model.Timesheet;
import com.ems.service.TimesheetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimesheetController {
    @Autowired
    TimesheetService timesheetService;



    @GetMapping("/timesheets/{timesheetId}")
    public Timesheet getTimesheet(@PathVariable(name = "timesheetId") int timesheetId) {
        return timesheetService.getTimesheet(timesheetId);
    }

    @PostMapping("/timesheets/create")
    Timesheet create(@RequestBody Timesheet timesheet) {

        return timesheetService.saveTimesheet(timesheet);

    }

    @PutMapping("/timesheets/{timesheetId}")
    public void updateTimesheet(@RequestBody Timesheet timesheet, @PathVariable(name = "timesheetId") int timesheetId) {
        Timesheet tim = timesheetService.getTimesheet(timesheetId);

        if (tim != null) {
            timesheetService.updateTimesheet(timesheet);
        }
    }

    @DeleteMapping("/timesheets/{timesheetId}")
    public void deleteTimesheet(@PathVariable(name = "timesheetId") int timesheetId) {
        timesheetService.deleteTimesheet(timesheetId);
        System.out.println("timesheet deleted successfully!");

    }
}
