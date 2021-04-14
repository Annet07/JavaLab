package ru.itis.javalab.homework;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class EntityManager {

    private final JdbcTemplate template;

    public EntityManager(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public <T> void createTable(String tableName, Class<T> entityClass) {
        StringBuilder createTable = new StringBuilder("CREATE TABLE ");
        createTable.append(tableName + "( ");
        Class<T> tClass = entityClass;
        Field fields[] = tClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            createTable.append(fields[i].getName()).append(" ");
            if (fields[i].getType().getSimpleName().equals("String") ||
                    fields[i].getType().getSimpleName().equals("char")) {
                createTable.append("varchar");
            } else if (fields[i].getType().getSimpleName().equals("Byte") ||
                    fields[i].getType().getSimpleName().equals("Integer") ||
                    fields[i].getType().getSimpleName().equals("Long") ||
                    fields[i].getType().getSimpleName().equals("Float") ||
                    fields[i].getType().getSimpleName().equals("Short")) {
                createTable.append("bigint");
            } else {
                createTable.append(fields[i].getType().getSimpleName());
            }
            if (i < fields.length - 1) {
                createTable.append(", ");
            }
        }
        createTable.append(");");
        template.update(createTable.toString());
    }

    public void save(String tableName, Object entity) {
        Class<?> classOfEntity = entity.getClass();
        StringBuilder saveString = new StringBuilder("insert into ");
        saveString.append(tableName).append("( ");
        Field fields[] = classOfEntity.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            saveString.append(fields[i].getName());
            if (i < fields.length - 1) {
                saveString.append(", ");
            }
        }
        saveString.append(")").append(" ").append("values ").append("(");
        for (int i = 0; i < fields.length; i++) {
            try {
                if (fields[i].getType().getSimpleName().equals("String")){
                    saveString.append("'");
                }
                saveString.append(fields[i].get(entity));
                if (fields[i].getType().getSimpleName().equals("String")){
                    saveString.append("'");
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
            if (i < fields.length - 1) {
                saveString.append(", ");
            }
        }
        saveString.append(");");
        template.execute(saveString.toString());
    }

    //User user = entityManager.findById("account", User.class, Long.class, 10L)
    public <T, ID> T findById(String tableName, Class<T> resultType, Class<ID> idType, ID idValue) {
        StringBuilder selectString = new StringBuilder("select * from ");
        selectString.append(tableName).append(" where id = ").append(idValue).append(";");

        RowMapper<T> rowMapper = (resultSet, i) -> {
            Constructor<T> constructor;
            T object;
            try {
                constructor = resultType.getConstructor();
                object = constructor.newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new IllegalArgumentException(e);
            }
            Field fields[] = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    field.set(object, resultSet.getObject(field.getName()));
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            return object;
        };
        try {
            return template.query(selectString.toString(), rowMapper).get(0);
        } catch (DataAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
