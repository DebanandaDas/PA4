package com.ems.controller;


import com.ems.model.Employee;
import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    @Autowired
    EmployeeController employeeController;
    @Autowired
    LoginController loginController;
    @Autowired
    TimesheetController timesheetController;

    @Test
    public void employeeTestCreateReadDelete(){

        List<Employee> employees = (List<Employee>)employeeController.getAll();
        int size = employees.size();

        Employee employee = new Employee();
        employee.setEmpName("Debananda");
        employee.setEmpContact(78);
        employee.setEmpEmail("deba@ps.com");
        employee.setEmpAddress("Assam");

        Employee employeeResult = employeeController.create(employee);
        employees = (List<Employee>)employeeController.getAll();

        Assertions.assertThat(employees).first().hasFieldOrPropertyWithValue("empName","Debananda");
        Assertions.assertThat(((List<Employee>)employeeController.getAll()).size()==size+1);
    }


//    @Test(expected= MethodArgumentNotValidException.class)
//    public void errorHandlingEmpNameNotSet(){
//        Employee employee = new Employee();
//
//        employee.setEmpContact(78);
//        employee.setEmpEmail("deba@ps.com");
//        employee.setEmpAddress("Assam");
//        employeeController.create(employee);
//    }

}
