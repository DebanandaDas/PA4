package com.ems.service;

import com.ems.model.Employee;
import com.ems.model.Login;
import com.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll()
    {
        List<Employee> employees= employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);

        return optEmp.get();
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);

    }

    @Override
    public Employee updateEmployee(Employee employee) {

       return employeeRepository.save(employee);

    }


}
