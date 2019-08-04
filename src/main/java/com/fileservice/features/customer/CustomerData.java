package com.fileservice.features.customer;

import com.fileservice.features.DataOperator;

import java.util.ArrayList;
import java.util.List;

public class CustomerData implements DataOperator {

    private static List<String> customerLines;
    private static CustomerData customerData = new CustomerData();

    public CustomerData() {
        customerLines = new ArrayList<>();
    }

    public static CustomerData getInstance() {
        return customerData;
    }

    @Override
    public void addLine(String line) {
        customerLines.add(line);
    }

    @Override
    public void clearData() {
        customerLines.clear();
    }

    @Override
    public List<String> getAll() {
        return customerLines;
    }
}
