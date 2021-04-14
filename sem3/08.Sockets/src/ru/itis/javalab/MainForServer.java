package ru.itis.javalab;

import com.beust.jcommander.JCommander;

public class MainForServer {

    public static void main(String[] args) {
        Args arg = new Args();
        JCommander.newBuilder()
                .addObject(arg)
                .build()
                .parse(args);
        EchoServerSocket serverSocket;
        if(arg.getPort() != 0){
            serverSocket = new EchoServerSocket(arg.getPort());
        } else {
            serverSocket = new EchoServerSocket();
        }
        serverSocket.init();
    }

}
