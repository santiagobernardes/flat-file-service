package com.fileservice.output.model;

import com.fileservice.features.salesman.model.SalesmanModel;
import com.fileservice.output.builder.OutputBuilder;

public class OutputModel {

    private Long amountOfClients;
    private Long amountOfSalesman;
    private Long mostExpensiveSaleId;
    private SalesmanModel worstSalesmanEver;

    public OutputModel() {
    }

    public OutputModel(Long amountOfClients, Long amountOfSalesman, Long mostExpensiveSaleId, SalesmanModel worstSalesmanEver) {
        this.amountOfClients = amountOfClients;
        this.amountOfSalesman = amountOfSalesman;
        this.mostExpensiveSaleId = mostExpensiveSaleId;
        this.worstSalesmanEver = worstSalesmanEver;
    }

    public Long getAmountOfClients() {
        return amountOfClients;
    }

    public Long getAmountOfSalesman() {
        return amountOfSalesman;
    }

    public Long getMostExpensiveSaleId() {
        return mostExpensiveSaleId;
    }

    public SalesmanModel getWorstSalesmanEver() {
        return worstSalesmanEver;
    }

    public static OutputBuilder builder() {
        return new OutputBuilder();
    }
}
