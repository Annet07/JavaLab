package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByEmail(String email);

}
