package ru.itis.javalab.repositories;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
                .name(row.getString("name"))
                .surname(row.getString("surname"))
                .age(row.getInt("age"))
                .aboutMe(row.getString("aboutMe"))
                .login(row.getString("login"))
                .password(row.getString("password"))
                .cookie(row.getString("cookie"))
                .isDeleted(row.getBoolean("is_deleted"))
                .build();

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into users_for_csrf(name, surname, age, aboutMe, login, password, cookie, is_deleted)" +
            " values(:name, :surname, :age, :aboutMe, :login, :password, :cookie, :isDeleted)";

    //language=SQL
    private static final String SQL_FIND_BY_COOKIE = "select * from users_for_csrf where cookie = ?";

    //language=SQL
    private static final String SQL_FIND_BY_LOGIN = "select * from users_for_csrf where login = ?";

    //language=SQL
    private static final String SQL_FIND_ALL_BY_ID = "select * from users_for_csrf where id = ?";

    //language=SQL
    private static final String SQL_FIND_ALL = "select * from users_for_csrf";

    //language=SQL
    private static final String SQL_FIND_ALL_WITH_PAGES = "select * from users_for_csrf order by id limit :limit offset :offset;";

    //language=SQL
    private static final String SQL_UPDATE_USER = "update users_for_csrf set name = :name, surname = :surname, age = :age, aboutMe = :aboutMe, login = :login, password = :password, cookie = :cookie, is_deleted = :isDeleted where id = :id;";

    //language=SQL
    private static final String SQL_FIND_ALL_BY_AGE = "select * from users_for_csrf where age = ?";

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAllByAge(int age) {
        return jdbcTemplate.query(SQL_FIND_ALL_BY_AGE, userRowMapper, age);
    }

    @Override
    public User getByCookie(String cookie) {
        return jdbcTemplate.query(SQL_FIND_BY_COOKIE, userRowMapper,cookie).get(0);
    }

    @Override
    public User checkUserLogAndPas(String login, String password) {
        if(jdbcTemplate.query(SQL_FIND_BY_LOGIN, userRowMapper,login).size() != 0){
            return jdbcTemplate.query(SQL_FIND_BY_LOGIN, userRowMapper,login).get(0);
        }
        return null;
    }

    @Override
    public List<User> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_WITH_PAGES,params,userRowMapper);
    }

    @Override
    public void save(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("surname", user.getSurname());
        params.put("age", user.getAge());
        params.put("aboutMe", user.getAboutMe());
        params.put("login", user.getLogin());
        params.put("password", user.getPassword());
        params.put("cookie", user.getCookie());
        namedParameterJdbcTemplate.update(SQL_INSERT_USER, params);
    }

    @Override
    public void update(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("surname", user.getSurname());
        params.put("age", user.getAge());
        params.put("aboutMe", user.getAboutMe());
        params.put("login", user.getLogin());
        params.put("password", user.getPassword());
        params.put("cookie", user.getCookie());
        params.put("isDeleted", user.getIsDeleted());
        params.put("id", user.getId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_USER, params);
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try{
            user = jdbcTemplate.queryForObject(SQL_FIND_ALL_BY_ID, userRowMapper, id);
        } catch (EmptyResultDataAccessException e){
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, userRowMapper);
    }
}
