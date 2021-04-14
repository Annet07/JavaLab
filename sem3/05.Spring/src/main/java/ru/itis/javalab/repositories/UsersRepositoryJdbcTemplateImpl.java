package ru.itis.javalab.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.*;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into account(first_name, last_name, email, hash_password)" +
            "values (:firstName, :lastName, :email, :hashPassword);";

    //language=SQL
    private static final String SQL_FIND_ONE_BY_EMAIL = "select * from account where email = :email limit 1;";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate template){
        this.jdbcTemplate = template;
    }

    private RowMapper<User> userRowMapper = (row, rowNumber) ->
        User.builder()
                .id(row.getLong("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .email(row.getString("email"))
                .hashPassword(row.getString("hash_password"))
                .build();

    @Override
    public Optional<User> findOneByEmail(String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_ONE_BY_EMAIL, Collections.singletonMap("email", email), userRowMapper));
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public void save(User entity) {
        //TODO: вставка ID после insert(как с помощью jdbcTemplate генерировать базой id)
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", entity.getFirstName());
        params.put("lastName", entity.getLastName());
        params.put("email", entity.getEmail());
        params.put("hashPassword", entity.getHashPassword());
        jdbcTemplate.update(SQL_INSERT, params);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
