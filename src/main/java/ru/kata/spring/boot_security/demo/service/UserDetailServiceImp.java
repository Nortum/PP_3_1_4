package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

@Service("UserDetailsService")
public class UserDetailServiceImp implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailServiceImp(UserService userService) {
        this.userService = userService;
    }

    // возвращение пользователя по его имени
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found"));
        }
        return user;
    }
}