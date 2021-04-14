package ru.itis.javalab.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class MailSenderImpl implements MailSender {

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String from, String subject, String text) {
        executorService.submit(() -> javaMailSender.send(message -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true);
        }));
    }
}
