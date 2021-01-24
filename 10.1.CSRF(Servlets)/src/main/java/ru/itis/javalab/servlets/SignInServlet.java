package ru.itis.javalab.servlets;
import org.springframework.context.ApplicationContext;
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

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
        this.usersService = applicationContext.getBean(UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/ftl/signIn_view.ftlh").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(usersService.checkUser(login, password) != null) {
            String cookieValue = usersService.checkUser(login, password);
            Cookie cookie = new Cookie("cookieValue", cookieValue);
            cookie.setMaxAge(60 * 60 * 24 * 365);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath()+"/profile");
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/signUp");
        }
    }
}
