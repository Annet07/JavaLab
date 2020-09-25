package ru.itis.app;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Downloader{

    private InputStream is;
    private OutputStream os;

    public Downloader(URL url, String folder){
        try {
            is = url.openStream();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        try {
            Path nameFile = Paths.get(url.getFile()).getFileName();
            Path path = Paths.get(folder, nameFile.toString());
            os = new FileOutputStream(path.toString());
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }

    public void download(){
        byte[] buffer = new byte[1584];
        int r;
        try {
            while((r = is.read(buffer, 0, 1584)) != -1){
                os.write(buffer, 0, r);
                Thread.sleep(50);
            }
        } catch (InterruptedException | IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
