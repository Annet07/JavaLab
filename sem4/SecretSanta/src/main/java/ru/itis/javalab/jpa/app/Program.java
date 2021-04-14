package ru.itis.javalab.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ru.itis.javalab.SecretSanta");
        EntityManager entityManager = factory.createEntityManager();


    }
}
