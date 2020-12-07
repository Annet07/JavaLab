package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class SignUpController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage(Model model){
        return "signUp_view";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request, HttpServletResponse response,
                          String name, String surname, String age, String aboutMe, String login, String password){
        Integer ageInt = Integer.parseInt(age);
        String hashPassword = passwordEncoder.encode(password);
        String cookieValue = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("cookieValue", cookieValue);
        response.addCookie(cookie);
        User user = new User(name, surname, ageInt, aboutMe, login, hashPassword, cookieValue);
        usersService.save(user);
        request.getSession().setAttribute("user", usersService.findByCookie(cookieValue));
        return "profile_view";
    }
}