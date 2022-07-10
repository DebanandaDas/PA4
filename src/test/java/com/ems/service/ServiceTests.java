package com.ems.service;


import com.ems.model.Employee;
import com.ems.model.Timesheet;
import com.ems.repository.EmployeeRepository;
import com.ems.repository.TimesheetRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest

//testing repositories
public class ServiceTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TimesheetRepository timesheetRepository;

    @Test
    public void testCreateReadEmployee() {
        Employee employee = new Employee();
        employee.setEmpName("Debananda");
        employee.setEmpContact(78);
        employee.setEmpEmail("deba@ps.com");
        employee.setEmpAddress("Assam");

        employeeRepository.save(employee);
        Iterable<Employee> employees = employeeRepository.findAll();
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("Debananda");
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setEmpName("Debananda");
        employee.setEmpContact(78);
        employee.setEmpEmail("deba@ps.com");
        employee.setEmpAddress("Assam");
        employeeRepository.save(employee);
        employeeRepository.deleteById(employee.getEmpID());
        Assertions.assertThat(employeeRepository.findAll()).isEmpty();
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmpName("Debananda");
        employee.setEmpContact(78);
        employee.setEmpEmail("deba@ps.com");
        employee.setEmpAddress("Assam");

        employeeRepository.save(employee);
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        employees.get(0).setEmpName("DebanandaUpdated");
        employeeRepository.save(employees.get(0));
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("DebanandaUpdated");
    }

    @Test
    public void testCreateReadTimesheets() {
        Employee employee = new Employee();
        employee.setEmpName("Debananda");
        employee.setEmpContact(78);
        employee.setEmpEmail("deba@ps.com");
        employee.setEmpAddress("Assam");
        employeeRepository.save(employee);
        Timesheet timesheet = new Timesheet();
        timesheet.setEmp(employee);
        timesheet.setTimeTask("testing");

        timesheetRepository.save(timesheet);
        Iterable<Timesheet> timesheets = timesheetRepository.findAll();
        Assertions.assertThat(timesheets).extracting(Timesheet::getTimeTask).contains("testing");
    }


}
