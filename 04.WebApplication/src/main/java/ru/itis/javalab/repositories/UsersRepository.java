package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import javax.servlet.http.Cookie;
import java.util.List;

public interface UsersRepository extends CrudRepository<User>{

    List<User> findAllByAge(int age);
    User getByCookie(String cookie);
    String checkUserLogAndPas(String login, String password);

}
