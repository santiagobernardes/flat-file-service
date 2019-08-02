package com.fileservice.app;

import com.fileservice.watcher.FileWatcher;

public class FileServiceApp {

    private static FileWatcher fileWatcher = new FileWatcher();

    public static void main(String[] args) {
        fileWatcher.startWatchingFiles();
    }
}
