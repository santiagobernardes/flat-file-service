package com.fileservice.features;

import java.util.List;

public interface DataOperator {

    void addLine(String line);

    void clearData();

    List<String> getAll();
}
