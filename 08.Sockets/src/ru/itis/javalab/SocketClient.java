package ru.itis.javalab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient implements ConnectionListener {

    protected Connection connection;

    public SocketClient(String ip, int port){
        try {
            Socket socket = new Socket(InetAddress.getByName(ip), port);
            connection = new ConnectionImpl(socket, this);
            openConnect(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void openConnect(Connection connection) {
        System.out.println("You was successfully connected!");
    }

    @Override
    public void closeConnect(Connection connection) {
        System.out.println("Connection was closed :(");
        connection.close();
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(message);
    }

    public void sendMessage(String message){
        connection.sendMessage(message);
    }

    /*public SocketClient(String host, int port){
        try {
            client = new Socket(host, port);
            toServer = new PrintWriter(client.getOutputStream(), true);
            fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            new Thread(receiverMessagesTask).start();
        } catch (IOException e){
            throw new IllegalStateException(e);
        }
    }

    public void sendMessage(String message){
        toServer.println(message);
    }

    private Runnable receiverMessagesTask = () -> {
        while (true){
            try {
                String messageFromServer = fromServer.readLine();
                if(messageFromServer != null){
                    System.out.println(messageFromServer);
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    };*/


}
