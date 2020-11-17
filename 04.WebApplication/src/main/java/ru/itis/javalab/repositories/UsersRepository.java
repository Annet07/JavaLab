package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User>{

    List<User> findAllByAge(int age);

}
