package com.fileservice.output;

import com.fileservice.features.customer.CustomerBusiness;
import com.fileservice.features.sale.SaleBusiness;
import com.fileservice.features.salesman.SalesmanBusiness;
import com.fileservice.features.salesman.model.SalesmanModel;
import com.fileservice.output.builder.OutputBuilder;
import com.fileservice.output.model.OutputModel;

public class OutputService {

    private CustomerBusiness customerBusiness;
    private SalesmanBusiness salesmanBusiness;
    private SaleBusiness saleBusiness;

    public OutputService() {
        this.customerBusiness = new CustomerBusiness();
        this.salesmanBusiness = new SalesmanBusiness();
        this.saleBusiness = new SaleBusiness();
    }

    public OutputModel buildOutputObject() {
        OutputModel build = OutputModel.builder()
                .amountClients(customerBusiness.countCustomers())
                .amountSalesman(salesmanBusiness.countSalesmen())
                .idMostExpensiveSale(saleBusiness.mostExpensiveSaleId())
                .worstSalesmanEver(saleBusiness.worstSalesmanEver())
                .build();

        System.out.println(buildContent(build));
        return build;
    }

    private String buildContent(OutputModel outputModel){
        return new StringBuilder().append("Amount of customers: ").append(outputModel.getAmountOfClients()).append("\n")
                .append("Amount of salesman: ").append(outputModel.getAmountOfSalesman()).append("\n")
                .append("Best Selling: ").append(outputModel.getMostExpensiveSaleId()).append("\n")
                .append("Worst Salesman ever: ").append(outputModel.getWorstSalesmanEver().getName()).append("\n")
                .toString();
    }
}
