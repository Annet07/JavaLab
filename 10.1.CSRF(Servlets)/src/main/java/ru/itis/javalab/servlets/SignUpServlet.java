package ru.itis.javalab.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.models.User;
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
import java.util.UUID;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersService usersService;
    private PasswordEncoder passwordEncoder;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
        this.usersService = applicationContext.getBean(UsersService.class);
        this.passwordEncoder = applicationContext.getBean(PasswordEncoder.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/ftl/signUp_view.ftlh").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String hashPassword = passwordEncoder.encode(password);
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String aboutMe = req.getParameter("aboutMe");
        String cookieValue = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("cookieValue", cookieValue);
        resp.addCookie(cookie);
        User user = User.builder().name(name).surname(surname).age(age).aboutMe(aboutMe).login(login).password(hashPassword).cookie(cookieValue).build();
        usersService.save(user);
        resp.sendRedirect(req.getContextPath()+"/profile");
    }
}
