//package ru.itis.javalab.hibernate.app;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import ru.itis.javalab.hibernate.entity.User;
//
//public class Program {
//    public static void main(String[] args){
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml___");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        User user = User.builder()
//                .build();
//        // user -> TRANSIENT
//        session.persist(user);
//        // user -> MANAGED
//        user.setName("ndfbnlfnblf");
//        session.getTransaction().commit();
//        sessionFactory.close();
//        // user -> DETACHED
//        user.setName("knblfgnb");
//
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.merge(user);
//        // MANAGED
//        session.getTransaction().commit();
//        session.close();
//    }
//}
