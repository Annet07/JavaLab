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
    public List<User> getAllUsers(int page, int size) {
        return usersRepository.findAll(page, size);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        usersRepository.save(User.builder()
        .name(user.getName())
        .surname(user.getSurname())
        .age(user.getAge())
        .aboutMe(user.getAboutMe())
        .login(user.getLogin())
        .password(user.getPassword())
        .cookie(user.getCookie())
        .build());
    }

    @Override
    public User getUser(Long userId) {
        return usersRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteUserById(long userId) {
        usersRepository.findById(userId).ifPresent(
                user -> {
                    user.setIsDeleted(true);
                    usersRepository.update(user);
                }
        );
    }

    @Override
    public User findByCookie(String cookie) {
        return usersRepository.getByCookie(cookie);
    }

    @Override
    public String checkUser(String login, String password) {
        User user =  usersRepository.checkUserLogAndPas(login,password);
        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            return user.getCookie();
        }
        return null;
    }
}
