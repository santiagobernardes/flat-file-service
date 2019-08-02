package com.fileservice.features.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerData {

    private static List<String> customerLines;
    private static CustomerData customerData = new CustomerData();

    public CustomerData() {
        customerLines = new ArrayList<>();
    }

    public static CustomerData getInstance() {
        return customerData;
    }

    public static void addLine(String line) {
        customerLines.add(line);
    }

    public static List<String> getAllCustomers() {
        return customerLines;
    }
}
