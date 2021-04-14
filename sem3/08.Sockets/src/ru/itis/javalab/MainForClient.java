package ru.itis.javalab;

import com.beust.jcommander.JCommander;

import java.util.Scanner;

public class MainForClient {
    public static void main(String[] args) {
        Args arg = new Args();
        JCommander.newBuilder()
                .addObject(arg)
                .build()
                .parse(args);
         SocketClient client = new SocketClient(arg.getIp(), arg.getPort());
         Scanner scanner = new Scanner(System.in);
         String message;
         while(!(message = scanner.nextLine().trim()).equals("exit")) {
             client.sendMessage(message);
        }
         client.closeConnect(client.connection);
    }
}
