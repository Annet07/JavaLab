package ru.itis.javalab.filters;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
public class ResponseUtil {
    public static void sendForbidden(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder path = new StringBuilder();

        path.append("/signIn");
        if (!request.getRequestURI().equals("/signIn")) {
            // signIn?redirect=users
            path
                    .append("?redirect=")
                    .append(request.getRequestURI());
        }
        if (request.getQueryString() != null) {
            path.append("?")
                    .append(request.getQueryString());
        }
        response.setStatus(403);
        response.sendRedirect(path.toString());
    }
}
