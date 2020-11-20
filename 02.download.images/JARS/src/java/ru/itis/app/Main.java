package ru.itis.app;

import com.beust.jcommander.JCommander;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.itis.app.Downloader;
import ru.itis.app.Args;

public class Main {
    public static void main(String... argv) {
        Args args = new Args();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
        ExecutorService executorService = Executors.newFixedThreadPool(args.count);
        Downloader downloader = new Downloader();
        String[] urls = args.files.split(";");

        for (int i = 0; i < urls.length; i++) {
            URL url;
            try {
                url = new URL(urls[i]);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException();
            }
            Path fileName = Paths.get(url.getFile()).getFileName();
            Path path = Paths.get(args.folder, fileName.toString());
            int k = i + 1;
            System.out.println("Starting download file number" + k);
            downloader.download(url, path);
            System.out.println("End download file number " + k);
        }
    }
}
