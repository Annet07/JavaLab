package ru.itis.javalab.front;

import ru.itis.javalab.services.UsersService;

import java.util.Scanner;

public class FrontImpl implements Front {

    private UsersService usersService;

    public FrontImpl(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("МЕНЮ:");
            System.out.println("1. Регистрация");
            System.out.println("2. Авторизация");
            System.out.println("3. Выход");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1: {
                    System.out.println("Введите имя:");
                    String firstName = scanner.nextLine();
                    System.out.println("Введите фамилию:");
                    String lastName = scanner.nextLine();
                    System.out.println("Введите email:");
                    String email = scanner.nextLine();
                    System.out.println("Введите пароль:");
                    String password = scanner.nextLine();
                    usersService.signUp(firstName, lastName, email, password);
                } break;
                case 2: {
                    System.out.println("Введите email:");
                    String email = scanner.nextLine();
                    System.out.println("Введите пароль:");
                    String password = scanner.nextLine();
                    usersService.signIn(email, password);
                } break;
                case 3: {
                    System.exit(0);
                } default:
                    System.err.println("Неверная комнада");
            }
        }
    }
}
