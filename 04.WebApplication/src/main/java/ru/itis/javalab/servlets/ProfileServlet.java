package ru.itis.javalab.servlets;

import ru.itis.javalab.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        this.usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("cookieValue")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                break;
            }
        }
        req.getSession().setAttribute("user", null);
        resp.sendRedirect(req.getContextPath()+"/signIn");
    }
}
