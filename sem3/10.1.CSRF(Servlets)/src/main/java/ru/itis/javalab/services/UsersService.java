package ru.itis.javalab.services;

import ru.itis.javalab.models.User;

import java.util.List;

public interface UsersService {
    void save(User user);
    List<User> getAllUsers(int page, int size);
    User findByCookie(String cookie);
    String checkUser(String login, String password);
    List<User> getAllUsers();
    void addUser(User user);
    User getUser(Long userId);

    void deleteUserById(long userId);
}
