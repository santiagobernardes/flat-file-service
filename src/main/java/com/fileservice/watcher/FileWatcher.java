package com.fileservice.watcher;

import com.fileservice.reader.DataReader;
import com.sun.nio.file.SensitivityWatchEventModifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FileWatcher {

    private static final Path pathToScan = Paths.get("./data/");
    private static final Path pathToWatch = Paths.get("./data/in");

    private static final Logger LOGGER = LogManager.getLogger();

    private DataReader dataReader = new DataReader();

    public void startWatchingFiles() throws IOException, InterruptedException {
        readExistentFiles();
        watchFiles();
    }

    private void readExistentFiles() {
        File[] inputFiles = Arrays.asList(
                Optional.ofNullable(new File(pathToScan.getFileName().toString()).listFiles((dir, name) -> name.startsWith("in")))
                .orElseThrow(NoSuchElementException::new))
                .get(0).listFiles((dir, name) -> name.endsWith(".dat"));

        List<File> fileList = Arrays.asList(inputFiles);

        if (!fileList.isEmpty()) dataReader.readFiles(fileList);
        else LOGGER.info("THERE ARE NO .dat FILES IN THE INPUT DIRECTORY");
    }

    private void watchFiles() throws IOException, InterruptedException {
        WatchService watcher = registerWatchService();
        WatchKey key;
        while ((key = watcher.take()) != null) {
            key.pollEvents().forEach(event -> {
                if (event.context().toString().endsWith(".dat")) {
                    readExistentFiles();
                } else {
                    LOGGER.error("FILE FORMAT NOT ACCEPTED");
                }
            });
            key.reset();
        }
    }

    private WatchService registerWatchService() throws IOException {
        WatchService watcher = pathToWatch.getFileSystem().newWatchService();
        pathToWatch.register(
                watcher,
                new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_MODIFY},
                SensitivityWatchEventModifier.HIGH);
        return watcher;
    }
}
