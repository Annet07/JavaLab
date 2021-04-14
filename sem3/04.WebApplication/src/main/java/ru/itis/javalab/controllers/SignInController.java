package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignInController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getSignInPage(HttpServletRequest request, HttpServletResponse response, Model model){
        return "signIn_view";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(HttpServletRequest request, HttpServletResponse response, String login, String password){
        if(usersService.checkUser(login, password) != null) {
            String cookieValue = usersService.checkUser(login, password);
            Cookie cookie = new Cookie("cookieValue", cookieValue);
            cookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(cookie);
            request.getSession().setAttribute("user", usersService.findByCookie(cookieValue));
            return "profile_view";
        }
        return "signUp_view";
    }
}
