package com.ems.repository;

import com.ems.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
    Login findByUsernameAndPassword(String username, String password);
}
