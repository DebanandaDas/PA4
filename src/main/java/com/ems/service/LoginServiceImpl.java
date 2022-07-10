package com.ems.service;

import com.ems.model.Employee;
import com.ems.model.Login;
import com.ems.repository.EmployeeRepository;
import com.ems.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Login getLogin(Login login) {
    return loginRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
    }

    @Override
    public Login saveLogin(Login login) {
        employeeRepository.save(login.getEmployee());
        loginRepository.save(login);
        return login;
    }


    @Override
    public void deleteLogin(int loginId) {
        loginRepository.deleteById(loginId);

    }


    @Override
    public void updateLogin(Login login) {
        loginRepository.save(login);
    }


}
