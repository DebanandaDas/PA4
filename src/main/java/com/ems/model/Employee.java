package com.ems.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")

@Data
@Entity
@Table(name = "Employees")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    int empID;

    @NotNull
    @Column(name = "EMP_NAME")
    String empName;
    @Column(name = "EMP_CONTACT")
    long empContact;
    @Column(name = "EMP_DEPARTMENT")
    String empDepartment;
    @Email
    @Column(name = "EMP_EMAIL")
    String empEmail;
    @Column(name = "EMP_ADDRESS")
    String empAddress;

    @JsonManagedReference
    public List<Timesheet> getTimesheetList() {
        return timesheetList;
    }

    public void setTimesheetList(List<Timesheet> timesheetList) {
        this.timesheetList = timesheetList;
    }

    @OneToMany(mappedBy="emp")
    private List<Timesheet> timesheetList= new ArrayList<>();



    public Employee(int empID, String empName, long empContact, String empDepartment, String empEmail,
                    String empAddress) {
        super();
        this.empID = empID;
        this.empName = empName;
        this.empContact = empContact;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
    }

    public Employee()
    {

    }

    @Override
    public String toString() {
        return "Employee [empID=" + empID + ", empName=" + empName + ", empContact=" + empContact + ", empDepartment="
                + empDepartment + ", empEmail=" + empEmail + ", empAddress=" + empAddress + "]";
    }

}