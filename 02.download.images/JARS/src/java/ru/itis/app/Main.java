package ru.itis.app;

import com.beust.jcommander.JCommander;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.itis.app.Downloader;

public class Main {
    public static void main(String... argv) {
        Args args = new Args();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
        ExecutorService executorService = Executors.newFixedThreadPool(args.count);
        String[] urls = args.files.split(";");

        for (int i = 0; i < urls.length; i++) {
            URL url;
            try {
                url = new URL(urls[i]);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException();
            }
            executorService.submit(() -> {
                Downloader downloader = new Downloader(url, args.folder);
                downloader.download();
            });
        }
    }
}
