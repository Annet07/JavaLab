package ru.itis.javalab.service;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.form.UserForm;

import java.util.Optional;

public interface UserService {
    void add(UserForm entity);
    Optional<UserDto> signIn(UserForm entity);
}
