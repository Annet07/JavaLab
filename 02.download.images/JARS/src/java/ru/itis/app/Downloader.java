package ru.itis.app;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Downloader{

    private final int size = 1584;
    private byte[] buffer;
    Queue<InputStream> is;
    Queue<OutputStream> os;

    public Downloader() {
        buffer = new byte[size];
        is = new ConcurrentLinkedQueue<>();
        os = new ConcurrentLinkedQueue<>();
    }

    public void download(URL url, Path path){
        int r;
        try {
            is.add(url.openStream());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        try {
            os.add(new FileOutputStream(path.toAbsolutePath().toString()));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }
        InputStream inputStream = is.poll();
        OutputStream outputStream = os.poll();
        try {
            boolean end = false;
            while (!end) {
                synchronized (buffer) {
                    if ((r = inputStream.read(buffer, 0, size)) != -1) {
                        outputStream.write(buffer, 0, r);
                    } else {
                        end = true;
                    }
                }
            }
            inputStream.close();
            outputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
