package ru.itis.javalab.services;

public interface SignInService {
    boolean authenticate(String email, String password);
}
