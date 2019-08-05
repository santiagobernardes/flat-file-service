package com.fileservice.features.sale.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaleModel {
    private String saleId;
    private List<ItemModel> items;
    private String salesman;
    private Double totalRevenue;
}
