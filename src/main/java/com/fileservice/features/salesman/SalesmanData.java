package com.fileservice.features.salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SalesmanData {

    private static List<String> salesmanLines;
    private static SalesmanData salesmanData = new SalesmanData();

    public SalesmanData() {
        salesmanLines = new ArrayList<>();
    }

    public static SalesmanData getInstance() {
        return salesmanData;
    }

    public static void addLine(String line) {
        salesmanLines.add(line);
    }

    public static List<String> getAllSalesmen() {
        return salesmanLines;
    }
}
