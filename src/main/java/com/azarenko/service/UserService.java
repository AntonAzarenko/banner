package com.azarenko.service;

import com.azarenko.entity.User;

public interface UserService {

    boolean add(User user);

    String getUserName();
}
