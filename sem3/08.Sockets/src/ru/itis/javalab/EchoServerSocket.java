package ru.itis.javalab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class EchoServerSocket implements ConnectionListener {

    private ServerSocket serverSocket;
    private List<Connection> connectionList;

    public EchoServerSocket(){
        try {
            serverSocket = new ServerSocket(Connection.port);
            connectionList = new LinkedList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EchoServerSocket(int port){
        try {
            serverSocket = new ServerSocket(port);
            connectionList = new LinkedList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init(){
        System.out.println("Server was started!");
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                openConnect(new ConnectionImpl(socket, this));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void openConnect(Connection connection) {
        connectionList.add(connection);
        System.out.println("Connection was added: " + connection.toString());
    }

    @Override
    public void closeConnect(Connection connection) {
        connectionList.remove(connection);
        System.out.println("Connection was removed: " + connection.toString());
        connection.close();
    }

    @Override
    public void receiveMessage(String message) {
        for (Connection connection: connectionList){
            if(connection.isActive()){
                connection.sendMessage(message);
            }
        }
    }

 /*   public void start(int port){
        ServerSocket server;

        try {
            server = new ServerSocket(port);
*//*
 * Уводит приложение в ожидание,пока не подключится клиента
 * как только клиент подключился,потом продолжает выполнение
 * и помещает клиента в переменную клиент*//*

            Socket client = server.accept();

////читаем сообщение от клиента
//            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
//            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);
//
//            String messageFromClient = fromClient.readLine();
//            while(messageFromClient != null){
//                System.out.println("Message from client: " + messageFromClient);
//                toClient.println("Message from server: " + messageFromClient);
//                messageFromClient = fromClient.readLine();
//            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }*/


}
