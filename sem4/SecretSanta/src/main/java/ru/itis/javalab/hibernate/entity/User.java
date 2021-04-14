//package ru.itis.javalab.hibernate.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class User{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String surname;
//    private Integer age;
//    private String wishes;
//    private String email;
//    private String password;
//    @OneToMany
//    private List<Message> messages;
//    @OneToMany
//    private List<Room> rooms;
//    @OneToMany
//    private List<Room> createdRooms;
//}
