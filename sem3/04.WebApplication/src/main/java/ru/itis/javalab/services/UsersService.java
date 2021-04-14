package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;

public interface UsersService {
    void save(User user);
    List<UserDto> getAllUsers(int page, int size);
    User findByCookie(String cookie);
    String checkUser(String login, String password);
    List<UserDto> getAllUsers();
    void addUser(UserDto userDto);
    UserDto getUser(Long userId);

}
