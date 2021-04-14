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
//public class Room {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    @ManyToOne
//    private User creator;
//    @OneToMany
//    private List<User> users;
//    @OneToMany
//    private List<Message> messages;
//}
