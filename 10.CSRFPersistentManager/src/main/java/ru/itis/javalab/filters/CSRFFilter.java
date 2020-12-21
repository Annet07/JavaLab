package ru.itis.javalab.filters;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static ru.itis.javalab.filters.ResponseUtil.sendForbidden;
@Slf4j
public class CSRFFilter implements Filter {
    private Set<String> csrfTokens;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        csrfTokens = new HashSet();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("hello from csrf filter");

        if (request.getMethod().equals("POST")) {
            String requestCsrf = request.getParameter("_csrf_token");

            if (((Set<String>) request.getSession(false).getAttribute("_csrf_tokens")).contains(requestCsrf)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            } else {
                sendForbidden(request, response);
                return;
            }
        }
        if (request.getMethod().equals("GET")) {


            String csrf = UUID.randomUUID().toString();
            request.setAttribute("_csrf_token", csrf);
            request.getSession().setAttribute("_csrf_token", csrf);

            if( request.getSession().getAttribute("_csrf_tokens")==null){
                log.info("csrf tokens hashset is null");
                csrfTokens = new HashSet<>();//если там ничего не было, то я создам новый сет csrf токенов

                csrfTokens.add(csrf);
                request.getSession().setAttribute("_csrf_tokens",csrfTokens);


            }else {
                log.info("csrf tokens hashset is not null");
                csrfTokens = (HashSet<String>) request.getSession().getAttribute("_csrf_tokens");
                csrfTokens.add(csrf);
                request.getSession().setAttribute("_csrf_tokens",csrfTokens);

            }
            csrfTokens.add(csrf); // и положу в него токен
            request.getSession().setAttribute("_csrf_tokens",csrfTokens);
            log.info("puted csrf roken {}",csrf);
            log.info("_csrf_tokens {}",csrfTokens);

            csrfTokens = new HashSet<>();
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
