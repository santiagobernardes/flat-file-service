package com.fileservice.features;

import com.fileservice.features.customer.CustomerData;
import com.fileservice.features.sale.SaleData;
import com.fileservice.features.salesman.SalesmanData;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataService {

    private CustomerData customerData;
    private SalesmanData salesmanData;
    private SaleData saleData;

    public DataService() {
        customerData = CustomerData.getInstance();
        salesmanData = SalesmanData.getInstance();
        saleData = SaleData.getInstance();
    }

    public void saveDataByFeature(String data) {
        if (data.startsWith(DataEnum.SALESMAN.getId())) salesmanData.addLine(data);
        if (data.startsWith(DataEnum.CUSTOMER.getId())) customerData.addLine(data);
        if (data.startsWith(DataEnum.SALE.getId())) saleData.addLine(data);
    }
}