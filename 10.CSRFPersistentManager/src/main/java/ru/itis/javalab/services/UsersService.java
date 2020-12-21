package ru.itis.javalab.services;

import ru.itis.javalab.models.User;

import java.util.Optional;

public interface UsersService {
    Optional<User> getUserById(Long id);

    void deleteUserById(long userId);
}
