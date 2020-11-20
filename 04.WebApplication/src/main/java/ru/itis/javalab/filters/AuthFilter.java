package ru.itis.javalab.filters;

import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/profile")
public class AuthFilter implements Filter {

    private UsersService usersService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getSession().getAttribute("user") == null) {
            Cookie[] cookies = req.getCookies();
            boolean flag = true;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookieValue")) {
                    req.getSession().setAttribute("user", usersService.findByCookie(cookie.getValue()));
                    flag = false;
                    break;
                }
            }
            if (flag) res.sendRedirect(req.getContextPath() + "/signIn");
            else filterChain.doFilter(request, response);
        }
        else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
