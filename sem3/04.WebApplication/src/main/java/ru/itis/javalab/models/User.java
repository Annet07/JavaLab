package ru.itis.javalab.models;

import lombok.*;


@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class User {
    private String name;
    private String surname;
    private Integer age;
    private String aboutMe;
    private String login;
    private String password;
    private String cookie;
    private Boolean isDeleted;

    public User(String name, String surname, Integer age, String aboutMe, String login, String password, String cookie, Boolean isDeleted) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.aboutMe = aboutMe;
        this.login = login;
        this.password = password;
        this.cookie = cookie;
        this.isDeleted = isDeleted;
    }
}


