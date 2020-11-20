package ru.itis.javalab.services;

import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;

public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User findByCookie(String cookie) {
        return usersRepository.getByCookie(cookie);
    }

    @Override
    public String checkUser(String login, String password) {
        return usersRepository.checkUserLogAndPas(login,password);
    }
}
