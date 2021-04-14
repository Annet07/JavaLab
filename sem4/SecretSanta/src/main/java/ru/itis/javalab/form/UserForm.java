package ru.itis.javalab.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private String name;
    private String surname;
    private Integer age;
    private String wishes;
    private String email;
    private String password;
}
