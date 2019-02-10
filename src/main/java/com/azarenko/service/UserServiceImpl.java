package com.azarenko.service;

import com.azarenko.entity.User;
import com.azarenko.repository.UserRepository;
import com.azarenko.web.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
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
