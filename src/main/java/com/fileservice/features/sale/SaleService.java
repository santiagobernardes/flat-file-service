package com.fileservice.features.sale;

import com.fileservice.features.sale.model.ItemModel;
import com.fileservice.features.sale.model.SaleModel;
import com.fileservice.parser.DataParser;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Triple;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SaleService {

    private SaleData saleData;
    private ItemService itemService;

    public SaleService() {
        saleData = SaleData.getInstance();
        itemService = new ItemService();
    }

    public String worstSalesmanEver() {
        List<String> salesmanList = getSalesList().stream()
                .map(SaleModel::getSalesman)
                .distinct()
                .collect(Collectors.toList());

        if (!salesmanList.isEmpty()) {
            Map<String, Double> salesmenWithSales = new HashMap<>();

            salesmanList.forEach(s -> salesmenWithSales.put(s, getRevenueBySalesman(s)));

            Map.Entry<String, Double> worstSalesman =
                    Collections.min(salesmenWithSales.entrySet(),
                            Comparator.comparingDouble(Map.Entry::getValue));

            return "THE WORST SALESMAN EVER is ".concat(worstSalesman.getKey())
                    .concat(", who billed only R$ ").concat(String.valueOf(worstSalesman.getValue()));
        } else return "";
    }

    public String mostExpensiveSale() {
        return getSalesList().stream()
                .max(Comparator.comparingDouble(SaleModel::getTotalRevenue))
                .map(sale -> {
                    return "The sale with the ID ".concat(sale.getSaleId())
                            .concat(" is the MOST EXPENSIVE one - ")
                            .concat("R$ ").concat(String.valueOf(sale.getTotalRevenue()))
                            .concat(" - and it was made by ").concat(sale.getSalesman());
                }).orElse("THE SYSTEM WASN'T ABLE TO FIND ANY REGISTERED SALE IN THE INPUT DIRECTORY");
    }

    public List<SaleModel> getSalesList() {
        return saleData.getAll().stream().distinct().map(this::createSaleModel).collect(Collectors.toList());
    }

    private Double getRevenueBySalesman(String salesman) {
        return getSalesList().stream()
                .filter(saleModel -> saleModel.getSalesman().equals(salesman))
                .mapToDouble(SaleModel::getTotalRevenue)
                .sum();
    }

    private SaleModel createSaleModel(String sale) {
        Triple<String, String, String> saleTriple = DataParser.getSplitedSale(sale);

        List<ItemModel> itemModelList = DataParser.getSplitedItems(saleTriple.getRight())
                .stream().map(itemService::createItemModel).collect(Collectors.toList());

        return new SaleModel(saleTriple.getLeft(), itemModelList, saleTriple.getMiddle(), totalRevenue(itemModelList));
    }

    private Double totalRevenue(List<ItemModel> items) {
        return items.stream().mapToDouble(itemModel -> itemModel.getPrice() * itemModel.getQuantity()).sum();
    }

    public void clear() {
        saleData.clearData();
    }
}
