//package ru.itis.javalab.hibernate.app;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//import ru.itis.javalab.hibernate.entity.Message;
//import ru.itis.javalab.hibernate.entity.Room;
//import ru.itis.javalab.hibernate.entity.User;
//
//public class ProgramForSubEntities {
//    public static void main(String[] args){
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml___");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//        Session session = sessionFactory.openSession();
//        Query<User> userQuery = session.createQuery("from User where id = 1", User.class);
//        User user = userQuery.getSingleResult();
//
//        Room room = Room.builder().build();
//
//        Message message = Message.builder()
//                .build();
//
//        session.beginTransaction();
//
//        session.save(room);
//        session.save(message);
//
//        session.getTransaction().commit();
//
//        session.close();
//        sessionFactory.close();
//    }
//}
