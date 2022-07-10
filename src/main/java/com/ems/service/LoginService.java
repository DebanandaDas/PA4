package com.ems.service;

import com.ems.model.Login;

public interface LoginService {
    Login getLogin(Login login);

    Login saveLogin(Login login);

    void deleteLogin(int loginId);

    void updateLogin(Login login);
}
