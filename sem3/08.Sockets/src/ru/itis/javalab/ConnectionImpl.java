package ru.itis.javalab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionImpl implements Connection, Runnable{

    private PrintWriter writer;
    private BufferedReader reader;
    private boolean isAlive = true;
    private ConnectionListener listener;

    public ConnectionImpl(Socket socket, ConnectionListener listener){
        try {
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.listener = listener;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void sendMessage(String message) {
        writer.println(message);
        writer.flush();
    }

    @Override
    public void close() {
        try {
            isAlive = false;
            writer.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isActive() {
        return isAlive;
    }

    @Override
    public void run() {
        while (isAlive){
            try {
                String message = reader.readLine();
                if (message != null) {
                    listener.receiveMessage(message);
                }
            } catch (IOException e) {

            }
        }
    }
}
