package com.ems.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Timesheets")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIMESHEET_ID")
    int timesheetId;

    @Column(name = "timeTotalHours")
    int timeTotalHours;

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private  Employee emp;
    @JsonBackReference
    public Employee getEmp() {
        return emp;
    }

    @Column(name = "timeDate")
    LocalDate timeDate;
    @Column(name = "timeTask")
    String timeTask;
    @Column(name = "timeDescription")
    String timeDescription;


    public Timesheet(Employee emp, int timeTotalHours, String empName, LocalDate timeDate, String timeTask,String timeDescription )
    {
        this.emp=emp;
        this.timeTotalHours=timeTotalHours;

        this.timeDate=timeDate;
        this.timeTask=timeTask;
        this.timeDescription=timeDescription;
    }

    @Override
    public String toString() {
        return "Timesheet{" +
                "timesheetId=" + timesheetId +
                ", timeTotalHours=" + timeTotalHours +
                ", timeDate=" + timeDate +
                ", timeTask='" + timeTask + '\'' +
                ", timeDescription='" + timeDescription + '\'' +
                ", emp=" + emp +
                '}';
    }

}
