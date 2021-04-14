package ru.itis.javalab;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.front.Front;
import ru.itis.javalab.front.FrontImpl;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.itis.javalab.services.MailsService;
import ru.itis.javalab.services.MailsServiceMockImpl;
import ru.itis.javalab.services.UsersService;
import ru.itis.javalab.services.UsersServiceImpl;

public class Application {
    public static void main(String[] args) {
        /**HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/java_lab_pract_2020");
        config.setDriverClassName("org.postgresql.Driver");
        config.setUsername("postgres");
        config.setPassword("07072001");
        config.setMaximumPoolSize(20);

        HikariDataSource dataSource = new HikariDataSource(config);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(jdbcTemplate);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        MailsService mailsService = new MailsServiceMockImpl();
        UsersService usersService = new UsersServiceImpl(usersRepository, passwordEncoder, mailsService);
        Front front = new FrontImpl(usersService);*/
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Front front = context.getBean(Front.class);
        front.run();
    }
}
