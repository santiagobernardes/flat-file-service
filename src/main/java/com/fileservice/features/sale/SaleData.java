package com.fileservice.features.sale;

import com.fileservice.features.DataOperator;

import java.util.ArrayList;
import java.util.List;

public class SaleData implements DataOperator {

    private static List<String> salesLines;
    private static SaleData saleData = new SaleData();

    public SaleData() {
        salesLines = new ArrayList<>();
    }

    public static SaleData getInstance() {
        return saleData;
    }

    @Override
    public void addLine(String line) {
        salesLines.add(line);
    }

    @Override
    public void clearData() {
        salesLines.clear();
    }

    @Override
    public List<String> getAll() {
        return salesLines;
    }
}
