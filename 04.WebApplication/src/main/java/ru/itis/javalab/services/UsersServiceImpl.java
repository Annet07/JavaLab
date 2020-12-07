package ru.itis.javalab.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;

import static ru.itis.javalab.dto.UserDto.from;

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
    public List<UserDto> getAllUsers(int page, int size) {
        return from(usersRepository.findAll(page, size));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public void addUser(UserDto userDto) {
        usersRepository.save(User.builder()
        .age(null)
        .name(userDto.getName())
        .surname(userDto.getSurname())
        .build());
    }

    @Override
    public UserDto getUser(Long userId) {
        return UserDto.from(usersRepository.findById(userId).orElse(null));
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
