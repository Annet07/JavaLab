package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.form.UserForm;
import ru.itis.javalab.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SignInController {

    @Autowired
    private UserService usersService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getSignInPage(HttpServletRequest request, HttpServletResponse response, Model model){
        return "signIn_view";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(HttpServletRequest request, HttpServletResponse response, UserForm userForm){
        Optional<UserDto> user = usersService.signIn(userForm);
        if(user.isPresent()){
            request.getSession().setAttribute("user", user);
            return "redirect:/profile";
        }
        return "signUp_view";
    }
}
