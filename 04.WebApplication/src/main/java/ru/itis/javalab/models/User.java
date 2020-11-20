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
}
