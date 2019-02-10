package com.azarenko.service;

import com.azarenko.entity.User;

public interface UserService {

    void add(User user);

    String getUserName();
}
