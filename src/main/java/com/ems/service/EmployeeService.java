package com.ems.service;

import com.ems.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getEmployee(int employeeId);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    Employee updateEmployee(Employee employee);
}
