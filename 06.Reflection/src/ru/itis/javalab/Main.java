package ru.itis.javalab;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.javalab.homework.EntityManager;
import ru.itis.javalab.homework.User;

import javax.sql.DataSource;

/**В этом классе мы можем:
 * Получить подробную информацию о полях класса
 * Получить подробную информацию о методах класса
 * Получить подробную информацию о конструкторах класса
 * Вызвать конструктор, создать объект
 * Вызвать метод над каким-нибудь объектом
 * Задавать значения полей
 */
public class Main {

    public static void main(String[] args) throws Exception{
//        /*Class<?> aClass = Component.class; // Получаем его экземпляр
//        Class<Component> aClass1 = Component.class; // Получаем его экземпляр*/
//        Class<?> aClass2 = Class.forName("ru.itis.javalab.Component"); // Получаем его экземпляр
//        Field fields[] = aClass2.getDeclaredFields(); //позволяет получить и приватные,и публичные
//        //  Field fields1[] = aClass2.getFields(); //позволяет получить ТОЛЬКО публичные поля
//        for(Field field: fields){
//            StringBuilder modifiers = new StringBuilder();
//
//            int modifiersCodes = field.getModifiers();
//            if (Modifier.isFinal(modifiersCodes)){
//                modifiers.append("final");
//                modifiers.append(" ");
//            }
//            if (Modifier.isPublic(modifiersCodes)){
//                modifiers.append("public");
//                modifiers.append(" ");
//            }
//            if (Modifier.isPrivate(modifiersCodes)){
//                modifiers.append("private");
//                modifiers.append(" ");
//            }
//            if (Modifier.isStatic(modifiersCodes)){
//                modifiers.append("static");
//                modifiers.append(" ");
//            }
//
//            //System.out.println(modifiers.toString() + field.getType() + " " + field.getName());
//            System.out.println(modifiers.toString() + field.getType().getSimpleName() + " " + field.getName());//показывает тип без пакета
//            }
///*
//        Method methods[] = aClass2.getDeclaredMethods();
//        for (Method method: methods) {
//            StringBuilder modifiers = new StringBuilder();
//            int modifiersCodes = method.getModifiers();
//            if (Modifier.isFinal(modifiersCodes)) {
//                modifiers.append("final");
//                modifiers.append(" ");
//            }
//            if (Modifier.isPublic(modifiersCodes)) {
//                modifiers.append("public");
//                modifiers.append(" ");
//            }
//            if (Modifier.isPrivate(modifiersCodes)) {
//                modifiers.append("private");
//                modifiers.append(" ");
//            }
//            if (Modifier.isStatic(modifiersCodes)) {
//                modifiers.append("static");
//                modifiers.append(" ");
//            }
//
//            StringBuilder parametersOfMethod = new StringBuilder();
//            Parameter parameters[] = method.getParameters();
//            for (Parameter parameter : parameters) {
//                parametersOfMethod.append(parameter.getType().getSimpleName())
//                        .append(" ").append(parameter.getName()).append(", ");
//            }
//            System.out.println(modifiers.toString() + method.getReturnType().getSimpleName() + " " + method.getName()
//                    + " (" + parametersOfMethod.toString() + ")");
//
//            //Constructor constructors[] = aClass2.getConstructors();
//
//            Object object = aClass2.newInstance();
//
//            Constructor<Component> constructor = (Constructor<Component>) aClass2.getConstructor(int.class, int.class);
//            Component component = constructor.newInstance(25,20);
//            System.out.println(component.getPublicFiled());
//
//            Method method1 = aClass2.getMethod("getSumOfFields", int.class);
//            Object result = method.invoke(component, 100);
//            System.out.println(result);
//
//            Field field = aClass2.getDeclaredField("privateField");
//            field.setAccessible(true);
//            field.setInt(component, 155);
//            System.out.println(component.getPublicFiled());
//        }*/

        String URL = "jdbc:postgresql://localhost:5432/java_lab_pract_2020";
        String USER = "postgres";
        String PASSWORD = "07072001";
        DataSource dataSource = new DriverManagerDataSource(URL, USER, PASSWORD);
        EntityManager entityManager = new EntityManager(dataSource);
        //System.out.println(entityManager.findById("entitymanager", User.class, Long.class, 2L));
        //entityManager.createTable("entitymanager", User.class);
        /*User user = new User(4L, "Leonid", "Tyshenko", true);
        entityManager.save("entitymanager", user);*/
    }
}
