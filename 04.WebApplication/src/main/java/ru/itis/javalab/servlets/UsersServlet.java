package ru.itis.javalab.servlets;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.repositories.UsersRepositoryJdbcImpl;
import ru.itis.javalab.services.UsersService;
import ru.itis.javalab.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/java_lab_pract_2020");
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("07072001");
        hikariConfig.setMaximumPoolSize(10);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        this.usersService = new UsersServiceImpl(usersRepository);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        System.out.println(usersService.getAllUsers());
    }
}
