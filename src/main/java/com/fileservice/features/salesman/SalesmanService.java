package com.fileservice.features.salesman;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@AllArgsConstructor
public class SalesmanService {

    private SalesmanData salesmanData;

    public SalesmanService() {
        salesmanData = SalesmanData.getInstance();
    }

    public String amountOfSalesmen() {
        long count = salesmanData.getAll().stream()
                .map(s -> Arrays.asList(StringUtils.splitByCharacterType(s.substring(4))).get(0))
                .distinct()
                .count();

        return "The TOTAL AMOUNT OF SALESMEN inside the input directory is: ".concat(String.valueOf(count));
    }

    public void clear() {
        salesmanData.clearData();
    }
}
