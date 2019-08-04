package com.fileservice.parser;

import com.fileservice.features.DataEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public static List<String> breakLines(List<String> lines) {
        return lines.stream().map(DataParser::breakEachLine).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static List<String> breakEachLine(String line) {
        String s1 = StringUtils.replace(line, " ".concat(DataEnum.SALESMAN.getId()), "/".concat(DataEnum.SALESMAN.getId()));
        String s2 = StringUtils.replace(s1, " ".concat(DataEnum.CUSTOMER.getId()), "/".concat(DataEnum.CUSTOMER.getId()));
        String s3 = StringUtils.replace(s2, " ".concat(DataEnum.SALE.getId()), "/".concat(DataEnum.SALE.getId()));

        return List.of(StringUtils.split(s3, "/"));
    }

    public static Triple<String, String, String> getSplitedSale(String sale) {
        String replace = StringUtils
                .replace(StringUtils
                        .replace(sale, "[", "/"), "]", "/");

        List<String> split = List.of(StringUtils.split(replace, "/"));

        return Triple.of(getSaleId(sale), getSaleman(split), getItens(split));
    }

    private static String getSaleId(String sale) {
        return sale.substring(4, 6);
    }

    private static String getSaleman(List<String> sale) {
        return sale.get(2).substring(1);
    }

    private static String getItens(List<String> sale) {
        return sale.get(1);
    }

    public static List<List<String>> getSplitedItems(String items) {

        List<String> split1 = List.of(StringUtils.split(items, ","));

        return split1.stream().map(s -> List.of(StringUtils.split(s, "-"))).collect(Collectors.toList());
    }
 }
