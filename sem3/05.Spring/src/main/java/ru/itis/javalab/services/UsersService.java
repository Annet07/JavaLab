package ru.itis.javalab.services;

public interface UsersService {
    void signUp(String firstName, String lastName, String email, String password);
    void signIn(String email, String password);
}
