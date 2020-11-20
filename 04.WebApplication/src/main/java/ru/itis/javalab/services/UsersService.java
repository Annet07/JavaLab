package ru.itis.javalab.services;

import ru.itis.javalab.models.User;

import java.util.List;

public interface UsersService {
    void save(User user);
    List<User> getAllUsers();
    User findByCookie(String cookie);
    String checkUser(String login, String password);

}
