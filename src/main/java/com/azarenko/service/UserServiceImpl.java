package com.azarenko.service;

import com.azarenko.web.LoggedUser;
import com.azarenko.entity.User;
import com.azarenko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoggedUser loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = userRepository.getByLogin(login);
        if (u == null) {
            throw new UsernameNotFoundException("User " + login + " not found!");
        }
        return new LoggedUser(u);
    }

    @Override
    public void add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public String getUserName() {
        LoggedUser loggedUser = LoggedUser.safeGet();
        if (loggedUser != null) {
             return loggedUser.getUserNick();
             }
        return null;
    }
}
