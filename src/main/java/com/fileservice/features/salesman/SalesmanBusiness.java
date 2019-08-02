package com.fileservice.features.salesman;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SalesmanBusiness {

    public static SalesmanData create(List<String> salesmen) {
        System.out.println("SALESMEN");
        System.out.println(salesmen.size());
        return new SalesmanData();
    }

    public Long countSalesmen() {
        return SalesmanData.getAllSalesmen().stream()
                .map(s -> Arrays.asList(StringUtils.splitByCharacterType(s.substring(4))).get(0))
                .distinct()
                .count();
    }


}
