package com.fileservice.watcher;

import com.fileservice.reader.DataReader;
import com.sun.nio.file.SensitivityWatchEventModifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FileWatcher {

    private static final Path pathToScan = Paths.get("./data/");
    private static final Path pathToWatch = Paths.get("./data/in");

    private static DataReader dataReader = new DataReader();

    public void startWatchingFiles() {
        readExistentFiles();
        try {
            watchFiles();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void readExistentFiles() {
        File[] inputFiles = List.of(
                Optional.ofNullable(new File(pathToScan.getFileName().toString()).listFiles((dir, name) -> name.startsWith("in")))
                .orElseThrow(NoSuchElementException::new))
                .get(0).listFiles((dir, name) -> name.endsWith(".dat"));

        List<File> fileList = List.of(inputFiles);

        if (!fileList.isEmpty()) dataReader.readFiles(fileList);
        else System.out.println("THERE IS NO FILES IN THE INPUT DIRECTORY");
    }

    private void watchFiles() throws IOException, InterruptedException {
        WatchService watcher = registerWatchService();
        WatchKey key;
        while ((key = watcher.take()) != null) {
            key.pollEvents().forEach(event -> {
                if (event.context().toString().endsWith(".dat")) {
                    readExistentFiles();
                } else {
                    System.out.println("FILE FORMAT NOT ACCEPTED");
                }
            });
            key.reset();
        }
    }

    private WatchService registerWatchService() throws IOException {
        WatchService watcher = pathToWatch.getFileSystem().newWatchService();
        pathToWatch.register(
                watcher,
                new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE},
                SensitivityWatchEventModifier.HIGH);
        return watcher;
    }
}
