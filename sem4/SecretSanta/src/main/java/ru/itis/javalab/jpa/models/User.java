package ru.itis.javalab.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Data
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Integer age;
    private String wishes;
    private String email;
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Message> messages;


    @ManyToMany(mappedBy = "users")
    private List<Room> rooms;

    @OneToMany(mappedBy = "creator")
    private List<Room> createdRooms;
}
