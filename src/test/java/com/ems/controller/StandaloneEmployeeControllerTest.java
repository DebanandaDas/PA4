package com.ems.controller;


import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class StandaloneEmployeeControllerTest {

    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete() throws Exception {
        Employee employee = new Employee();
        employee.setEmpName("Debananda");
        employee.setEmpContact(78);
        employee.setEmpEmail("deba@ps.com");
        employee.setEmpAddress("Assam");
        List<Employee> employees= Arrays.asList(employee);

        Mockito.when(employeeService.getAll()).thenReturn(employees);

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].empName", Matchers.is("Debananda")));
    }
}
