package com.fileservice.app;

import com.fileservice.watcher.FileWatcher;

import java.io.IOException;

public class FileServiceApp {

    private static FileWatcher fileWatcher = new FileWatcher();

    public static void main(String[] args) throws IOException, InterruptedException {
        fileWatcher.startWatchingFiles();
    }
}
