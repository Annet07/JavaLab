package ru.itis.javalab;

public interface Connection {

    int port = 4321;

    void sendMessage(String message);
    void close();
    boolean isActive();
}
