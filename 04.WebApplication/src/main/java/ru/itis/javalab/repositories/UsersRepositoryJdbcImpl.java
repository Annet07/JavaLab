package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository{

    //language=SQL
    private static final String SQL_FIND_ALL = "select * from users";

    //language=SQL
    private static final String SQL_FIND_ALL_BY_AGE = "select * from users where age = ?";

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into USERS(name, surname, age, aboutMe, login, password, cookie)" +
            " values(?, ?, ?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_FIND_BY_COOKIE = "select * from USERS where cookie = ?";

    //language=SQL
    private static final String SQL_FIND_BY_LOGIN = "select * from USERS where login = ?";

    private SimpleJdbcTemplate<User> template;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.template = new SimpleJdbcTemplate<>(dataSource);
    }

    private RowMapper<User> userRowMapper = row -> User.builder()
            .name(row.getString("name"))
            .surname(row.getString("surname"))
            .age(row.getInt("age"))
            .aboutMe(row.getString("aboutMe"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .cookie(row.getString("cookie"))
            .build();


    @Override
    public void save(User user) {
        template.execute(SQL_INSERT_USER, user.getName(), user.getSurname(), user.getAge(), user.getAboutMe(), user.getLogin(), user.getPassword(), user.getCookie());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {

        return template.query(SQL_FIND_ALL, userRowMapper);
    }

    @Override
    public List<User> findAllByAge(int age) {

        return template.query(SQL_FIND_ALL_BY_AGE, userRowMapper, age);

    }

    @Override
    public User getByCookie(String cookie) {
        return template.query(SQL_FIND_BY_COOKIE, userRowMapper,cookie).get(0);
    }

    @Override
    public User checkUserLogAndPas(String login, String password) {
        return template.query(SQL_FIND_BY_LOGIN, userRowMapper,login).get(0);

    }


}
