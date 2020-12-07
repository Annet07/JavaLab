/*
package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersController implements Controller {

    @Autowired
    private UsersService usersService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("users", usersService.getAllUsers());
            modelAndView.setViewName("users_view");
            return modelAndView;
        }
        return null;
    }
}
*/
