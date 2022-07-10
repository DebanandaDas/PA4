package com.ems.controller;

import com.ems.model.Employee;
import com.ems.model.Login;
import com.ems.service.EmployeeService;
import com.ems.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;


    //need to implement this method later
    @PostMapping("/login")
    Login login(@Valid @RequestBody Login login) {
        return loginService.getLogin(login);
    }


    @PostMapping("/login/create")
    Login create(@Valid @RequestBody Login login) {

        return loginService.saveLogin(login);
    }

    @PutMapping("/login/{loginId}")
    public void updateLogin(@Valid @RequestBody Login login, @PathVariable(name = "loginId") int loginId) {
        Login emp = loginService.getLogin(login);

        if (emp != null) {
            loginService.updateLogin(login);
        }
    }

    @DeleteMapping("/login/{loginId}")
    public void deleteLogin(@PathVariable(name = "loginId") int loginId) {
        loginService.deleteLogin(loginId);
        System.out.println("Login deleted successfully!");

    }
}
