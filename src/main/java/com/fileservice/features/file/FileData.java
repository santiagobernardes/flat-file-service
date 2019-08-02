package com.fileservice.features.file;

import java.util.ArrayList;
import java.util.List;

public class FileData {

    private static FileData fileData = new FileData();
    private List<String> allLines;

    public FileData() {
        allLines = new ArrayList<>();
    }

    public static FileData getInstance() {
        return fileData;
    }

    public void addLines(List<String> strings) {
        strings.forEach(s -> allLines.add(s));
    }

    public void clearData() {
        allLines.clear();
    }

    public List<String> getAllLines() {
        return allLines;
    }

}
