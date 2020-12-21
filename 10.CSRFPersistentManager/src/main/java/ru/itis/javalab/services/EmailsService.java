package ru.itis.javalab.services;

public interface EmailsService {
    void sendMail(String subject, String text, String email);
}
