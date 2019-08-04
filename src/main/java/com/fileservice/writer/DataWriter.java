package com.fileservice.writer;

import com.fileservice.features.customer.CustomerService;
import com.fileservice.features.sale.SaleService;
import com.fileservice.features.salesman.SalesmanService;
import lombok.AllArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
public class DataWriter {

    private static final String outputPath = "./data/out/";
    private static final String outputFileName = "output_file.done.dat";

    private CustomerService customerService;
    private SalesmanService salesmanService;
    private SaleService saleService;

    public DataWriter() {
        this.customerService = new CustomerService();
        this.salesmanService = new SalesmanService();
        this.saleService = new SaleService();
    }

    public List<String> writeOutput() {

        List<String> outputData = List.of(
                customerService.amountOfCustomers(),
                salesmanService.amountOfSalesmen(),
                saleService.mostExpensiveSale(),
                saleService.worstSalesmanEver()
        );

        createOutputFile(outputData);
        return outputData;
    }

    private void createOutputFile(List<String> outputData) {
        try {
            System.out.println("_______________________________________________________________________");
            outputData.forEach(l -> System.out.println(l));
            System.out.println("_______________________________________________________________________");
            Files.write(Paths.get(outputPath.concat(outputFileName)), outputData, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            clearData();
        }
    }

    private void clearData() {
        customerService.clear();
        salesmanService.clear();
        saleService.clear();
    }
}
