package com.fileservice.features.sale;

import com.fileservice.features.sale.item.model.ItemModel;
import com.fileservice.features.sale.model.SaleModel;
import com.fileservice.features.salesman.model.SalesmanModel;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class SaleBusiness {

    public SalesmanModel worstSalesmanEver() {

        Map<String, Double> salesmenWithSales = new HashMap<>();

        getSalesList().stream().map(SaleModel::getSalesman).distinct().collect(Collectors.toList())
                .forEach(s -> salesmenWithSales.put(s, getAmountBySalesman(s)));

        System.out.println(salesmenWithSales);

        String worstSalesman = Collections.min(salesmenWithSales.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();

        System.out.println(worstSalesman);

        return new SalesmanModel("000000", worstSalesman, 1000.0);
    }

    private Double getAmountBySalesman(String salesman) {
        return getSalesList().stream()
                .filter(saleModel -> saleModel.getSalesman().equals(salesman))
                .mapToDouble(SaleModel::getTotalRevenue)
                .sum();
    }

    public Long mostExpensiveSaleId() {
        Double highestValue = getSalesList().stream().mapToDouble(SaleModel::getTotalRevenue).max().orElse(0);
        SaleModel saleModel1 = getSalesList().stream().filter(saleModel -> saleModel.getTotalRevenue().equals(highestValue)).collect(Collectors.toList()).get(0);
        return saleModel1.getSaleId();
    }

    private Double totalRevenue(List<ItemModel> items) {
        return items.stream().mapToDouble(itemModel -> itemModel.getPrice() * itemModel.getQuantity()).sum();
    }

    private List<SaleModel> getSalesList() {
        return SaleData.getAllSales().stream().map(this::createSaleModel).collect(Collectors.toList());
    }

    private SaleModel createSaleModel(String sale) {
        String saleId = sale.substring(4, 6);

        String items = StringUtils
                .replace(StringUtils
                        .replace(sale, "[", "/"), "]", "/");

        List<String> split = List.of(StringUtils.split(items, "/"));

        String itens = split.get(1);

        String salesman = split.get(2).substring(1);

        List<String> split1 = List.of(StringUtils.split(itens, ","));

        List<List<String>> collect = split1.stream().map(s -> List.of(StringUtils.split(s, "-"))).collect(Collectors.toList());

        List<ItemModel> collect1 = collect.stream().map(this::createItemModel).collect(Collectors.toList());

        return new SaleModel(Long.valueOf(saleId), collect1, salesman, totalRevenue(collect1));
    }

    private ItemModel createItemModel(List<String> sale) {
        return new ItemModel(
                Integer.valueOf(sale.get(0)),
                Integer.valueOf(sale.get(1)),
                Double.valueOf(sale.get(2)));
    }
}
