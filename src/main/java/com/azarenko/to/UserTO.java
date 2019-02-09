package com.azarenko.to;

import com.azarenko.entity.Role;
import com.azarenko.entity.User;

public class UserTO {
    private int id;

    private String name;

    private String login;

    private String password;

    public User asUser(){
        return new User (null, name, login, password, true, Role.ROLE_USER);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
