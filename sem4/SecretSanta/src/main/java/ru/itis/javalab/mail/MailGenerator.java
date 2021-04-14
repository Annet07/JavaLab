package ru.itis.javalab.mail;

public interface MailGenerator {
    String generateConfirmEmail(String serverUrl, String code);
}
