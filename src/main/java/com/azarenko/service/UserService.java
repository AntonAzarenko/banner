package com.azarenko.service;

import com.azarenko.entity.User;

import java.util.List;

public interface UserService {

    void add(User user);

    String getUserName();
}
