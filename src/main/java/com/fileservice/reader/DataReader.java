package com.fileservice.reader;

import com.fileservice.features.DataService;
import com.fileservice.writer.DataWriter;
import com.fileservice.parser.DataParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private DataWriter dataWriter;
    private DataService dataService;

    public DataReader() {
        this.dataWriter = new DataWriter();
        this.dataService = new DataService();
    }

    public void readFiles(List<File> files) {
        List<String> lines = files.stream()
                .map(this::readLines).flatMap(Collection::stream).collect(Collectors.toList());

        DataParser.breakLines(lines).forEach(dataService::saveDataByFeature);

        dataWriter.writeOutput();
    }

    private List<String> readLines(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
