package ru.itis.javalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.jpa.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
