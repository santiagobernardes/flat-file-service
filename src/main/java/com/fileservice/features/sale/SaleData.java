package com.fileservice.features.sale;

import com.fileservice.features.salesman.SalesmanData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaleData {

    private static List<String> salesLines;
    private static SaleData saleData = new SaleData();

    public SaleData() {
        salesLines = new ArrayList<>();
    }

    public static SaleData getInstance() {
        return saleData;
    }

    public static void addLine(String line) {
        salesLines.add(line);
    }

    public static List<String> getAllSales() {
        List<String> collect = salesLines.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }
}
