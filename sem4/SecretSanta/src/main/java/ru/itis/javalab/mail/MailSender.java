package ru.itis.javalab.mail;

public interface MailSender {
    void sendEmail(String to, String from, String subject, String text);
}
