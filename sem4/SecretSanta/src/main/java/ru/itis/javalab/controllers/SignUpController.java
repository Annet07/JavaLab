package ru.itis.javalab.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.form.UserForm;
import ru.itis.javalab.service.UserService;
import javax.servlet.http.HttpServletRequest;


@Controller
public class SignUpController {

    @Autowired
    private UserService usersService;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage(){
        return "signUp_view";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request, UserForm userForm){
        usersService.add(userForm);
        request.getSession().setAttribute("user", UserDto.builder()
                .name(userForm.getName())
                .surname(userForm.getSurname())
                .age(userForm.getAge())
                .wishes(userForm.getWishes())
                .email(userForm.getEmail())
                .build());
        return "redirect:/profile";
    }
}
