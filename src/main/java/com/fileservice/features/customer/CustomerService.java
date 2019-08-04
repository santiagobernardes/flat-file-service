package com.fileservice.features.customer;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@AllArgsConstructor
public class CustomerService {

    private CustomerData customerData;

    public CustomerService() {
        customerData = CustomerData.getInstance();
    }

    public String amountOfCustomers() {
        long count = customerData.getAll().stream()
                .map(s -> Arrays.asList(StringUtils.splitByCharacterType(s.substring(4))).get(0))
                .distinct()
                .count();

        return "The TOTAL AMOUNT OF CUSTOMERS inside de input directory is: ".concat(String.valueOf(count));
    }

    public void clear() {
        customerData.clearData();
    }
}
