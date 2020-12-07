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
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(HttpServletRequest request, HttpServletResponse response, Model model){
        if (request.getSession().getAttribute("user") != null){
            model.addAttribute("user", request.getSession().getAttribute("user"));
            return "profile_view";
        } else {
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("cookieValue")){
                    model.addAttribute("user", usersService.findByCookie(cookie.getValue()));
                    return "profile_view";
                }
            }
        }
        return "signUp_view";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String logOff(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("cookieValue")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        request.getSession().setAttribute("user", null);
        return "signIn_view";
    }
}
