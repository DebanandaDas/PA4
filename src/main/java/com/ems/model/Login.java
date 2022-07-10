package com.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name= "LOGINS")
public class Login {

    @Id
    @Column(name = "login_id")
            @GeneratedValue(strategy = GenerationType.AUTO)
    int loginId;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private char role;
    @Column(name = "LOGIN_STATUS")
    public boolean loginStatus;

    @OneToOne
    @JoinColumn(name="emp_id")
    public Employee employee;

    public Login(String username, String password, char role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public Login()
    {

    }

}
