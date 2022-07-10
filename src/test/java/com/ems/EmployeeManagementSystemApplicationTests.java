package com.ems;

import com.ems.controller.EmployeeController;
import com.ems.controller.LoginController;
import com.ems.controller.TimesheetController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
//sanity check
class EmployeeManagementSystemApplicationTests {


	@Autowired
	EmployeeController employeeController;

	@Autowired
	LoginController loginController;
	@Autowired
	TimesheetController timesheetController;

	@Test
	public void contextLoads() {
    Assert.assertNotNull(employeeController);
	Assert.assertNotNull(timesheetController);
	Assert.assertNotNull(loginController);
	}

}
