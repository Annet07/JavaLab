package ru.itis.javalab.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Optional<User> getUserById(Long id) {
        return usersRepository.findOne(id);
    }

    @Override
    public void deleteUserById(long userId) {
        usersRepository.findOne(userId)
                .ifPresent(
                        user -> {
                            user.setIsDeleted(true);
                            usersRepository.update(user);
                        }
                );
    }
}
