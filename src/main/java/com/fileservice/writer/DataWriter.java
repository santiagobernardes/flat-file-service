package com.fileservice.writer;

import com.fileservice.features.customer.CustomerService;
import com.fileservice.features.sale.SaleService;
import com.fileservice.features.salesman.SalesmanService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class DataWriter {

    private static final String outputPath = "./data/out/";
    private static final String outputFileName = "output_file.done.dat";

    private static final Logger LOGGER = LogManager.getLogger();

    private CustomerService customerService;
    private SalesmanService salesmanService;
    private SaleService saleService;

    public DataWriter() {
        this.customerService = new CustomerService();
        this.salesmanService = new SalesmanService();
        this.saleService = new SaleService();
    }

    public List<String> writeOutput() {

        List<String> outputData = Stream.of(
                customerService.amountOfCustomers(),
                salesmanService.amountOfSalesmen(),
                saleService.mostExpensiveSale(),
                saleService.worstSalesmanEver()
        )
                .distinct().collect(Collectors.toList());

        createOutputFile(outputData);
        return outputData;
    }

    private void createOutputFile(List<String> outputData) {
        try {
            Files.write(Paths.get(outputPath.concat(outputFileName)), outputData, StandardCharsets.UTF_8);
            outputData.forEach(LOGGER::debug);
        } catch (IOException ex) {
            LOGGER.error("An error happened while trying to write the file: ".concat(ex.getMessage()));
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
