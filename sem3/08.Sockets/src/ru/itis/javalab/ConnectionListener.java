package ru.itis.javalab;

public interface ConnectionListener {

    void openConnect(Connection connection);
    void closeConnect(Connection connection);
    void receiveMessage(String message);
}
