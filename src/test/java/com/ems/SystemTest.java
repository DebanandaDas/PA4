package com.ems;



import com.ems.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SystemTest {

//    @Test
//    public void testCreateReadDelete() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/employees/create";
//        Employee employee=new Employee();
//        employee.setEmpName("Debananda");
//        employee.setEmpContact(78);
//        employee.setEmpEmail("deba@ps.com");
//        employee.setEmpAddress("Assam");
//
//
//        ResponseEntity<Employee> entity = restTemplate.postForEntity(url, employee, Employee.class);
//        url="http://localhost:8080/employees";
//        Employee[] employees = restTemplate.getForObject(url, Employee[].class);
//
//        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("Debananda");
//
//
//        restTemplate.delete(url + "/" + entity.getBody().getEmpID());
//        Assertions.assertThat(restTemplate.getForObject(url, Employee[].class)).isEmpty();
//
//    }

}
