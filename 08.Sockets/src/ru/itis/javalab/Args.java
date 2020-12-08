package ru.itis.javalab;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.ArrayList;
import java.util.List;

@Parameters(separators = "=")
public class Args {


    @Parameter(names = "--server-ip")
    private String ip;

    @Parameter(names = "--port")
    private int port;


    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
