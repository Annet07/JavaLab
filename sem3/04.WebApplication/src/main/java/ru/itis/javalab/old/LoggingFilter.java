/*
package ru.itis.javalab.filters;

import ru.itis.javalab.logs.MyLogger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MyLogger.logMessage(((HttpServletRequest) request).getServletPath());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
*/
