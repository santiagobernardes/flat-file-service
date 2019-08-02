package com.fileservice.features.customer;

import com.fileservice.features.salesman.SalesmanData;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerBusiness {

    public Long countCustomers() {
        return CustomerData.getAllCustomers().stream()
                .map(s -> Arrays.asList(StringUtils.splitByCharacterType(s.substring(4))).get(0))
                .distinct()
                .count();
    }
}
