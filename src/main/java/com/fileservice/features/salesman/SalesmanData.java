package com.fileservice.features.salesman;

import com.fileservice.features.DataOperator;

import java.util.ArrayList;
import java.util.List;

public class SalesmanData implements DataOperator {

    private static List<String> salesmanLines;
    private static SalesmanData salesmanData = new SalesmanData();

    public SalesmanData() {
        salesmanLines = new ArrayList<>();
    }

    public static SalesmanData getInstance() {
        return salesmanData;
    }

    @Override
    public void addLine(String line) {
        salesmanLines.add(line);
    }

    @Override
    public void clearData() {
        salesmanLines.clear();
    }

    @Override
    public List<String> getAll() {
        return salesmanLines;
    }
}
