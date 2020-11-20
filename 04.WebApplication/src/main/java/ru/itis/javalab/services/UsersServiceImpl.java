package ru.itis.javalab.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;

public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
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
        User user =  usersRepository.checkUserLogAndPas(login,password);
        if(passwordEncoder.matches(password, user.getPassword())){
            return user.getCookie();
        }
        return null;
    }
}
