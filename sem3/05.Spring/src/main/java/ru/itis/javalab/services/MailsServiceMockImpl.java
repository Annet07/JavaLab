package ru.itis.javalab.services;

public class MailsServiceMockImpl implements MailsService {
    @Override
    public void sendMail(String email, String message) {
        System.err.println("Сообщение <" + message + "> отправлено на : " + email);
    }
}
