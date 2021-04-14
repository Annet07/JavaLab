package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UserService usersService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(HttpServletRequest request, HttpServletResponse response, Model model){
        Optional<UserDto> user = (Optional<UserDto>) request.getSession().getAttribute("user");
        if(!user.isPresent()){
            return "redirect:/signIn";
        }
        model.addAttribute("user", user.get());
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
