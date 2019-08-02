package com.fileservice.features.sale.model;

import com.fileservice.features.sale.item.model.ItemModel;

import java.util.List;

public class SaleModel {
    private Long saleId;
    private List<ItemModel> items;
    private String salesman;
    private Double totalRevenue;

    public SaleModel() {
    }

    public SaleModel(Long saleId, List<ItemModel> items, String salesman, Double totalRevenue) {
        this.saleId = saleId;
        this.items = items;
        this.salesman = salesman;
        this.totalRevenue = totalRevenue;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
