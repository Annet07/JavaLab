package ru.itis.javalab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.jpa.models.User;
import ru.itis.javalab.form.UserForm;
import ru.itis.javalab.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void add(UserForm entity) {
        User user = User.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .age(entity.getAge())
                .wishes(entity.getWishes())
                .email(entity.getEmail())
                .password(passwordEncoder.encode(entity.getPassword()))
                .build();
        userRepository.save(user);
    }

    @Override
    public Optional<UserDto> signIn(UserForm entity) {
        Optional<User> user = userRepository.findByEmail(entity.getEmail());
        if(user.isPresent() && passwordEncoder.matches(entity.getPassword(), user.get().getPassword())){
            User user1 = user.get();
            return Optional.of(UserDto.builder().name(user1.getName())
                    .surname(user1.getSurname()).age(user1.getAge())
                    .wishes(user1.getWishes()).email(user1.getEmail()).build());
        }
        return Optional.empty();
    }
}
