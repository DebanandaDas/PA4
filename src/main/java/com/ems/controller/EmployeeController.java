package com.ems.controller;

import com.ems.model.Employee;
import com.ems.model.Timesheet;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;


@RestController
public class EmployeeController {
  @Autowired EmployeeService employeeService;

  @GetMapping("/employees")
  Iterable<Employee> getAll() {
    return employeeService.getAll();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee getEmployee(@PathVariable(name = "employeeId") int employeeId) {
    return employeeService.getEmployee(employeeId);
  }

  @PostMapping("/employees/create")
  Employee create( @Valid @RequestBody Employee employee) {

    return employeeService.saveEmployee(employee);

  }

  @PutMapping("/employees/{employeeId}")
  public Employee updateEmployee(@Valid @RequestBody Employee employee, @PathVariable(name = "employeeId") int employeeId) {
    Employee emp = employeeService.getEmployee(employeeId);

    if (emp != null) {
      return employeeService.updateEmployee(employee);
    }
    return null;
  }

  @DeleteMapping("/employees/{employeeId}")
  public void deleteEmployee(@PathVariable(name = "employeeId") int employeeId) {
    employeeService.deleteEmployee(employeeId);
    System.out.println("Employee deleted successfully!");

  }

  @GetMapping("/employees/timesheets/{employeeId}")
  public List<Timesheet> getTimesheetsForEmployee(@PathVariable(name = "employeeId") int employeeId) {
    return employeeService.getEmployee(employeeId).getTimesheetList();
  }
}
