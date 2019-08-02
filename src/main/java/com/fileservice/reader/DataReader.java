package com.fileservice.reader;

import com.fileservice.features.customer.CustomerBusiness;
import com.fileservice.features.customer.CustomerData;
import com.fileservice.features.file.FileData;
import com.fileservice.features.sale.SaleData;
import com.fileservice.features.salesman.SalesmanBusiness;
import com.fileservice.features.salesman.SalesmanData;
import com.fileservice.output.OutputService;
import com.fileservice.output.model.OutputModel;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private static final String SALESMAN_ID = "001";
    private static final String CUSTOMER_ID = "002";
    private static final String SALE_ID = "003";

    private OutputService outputService = new OutputService();

    private FileData fileData;
    private CustomerData customerData;

    public DataReader() {
        this.fileData = FileData.getInstance();
        this.customerData = CustomerData.getInstance();
    }

    public void readFiles(List<File> files) {
        fileData.clearData();
        files.stream()
                .map(this::readEachLine)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .forEach(this::breakLines);

        fileData.getAllLines().forEach(this::checkDataType);

        OutputModel outputModel = outputService.buildOutputObject();
        System.out.println(outputModel.toString());
    }

    private List<String> readEachLine(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void breakLines(String string) {
        String replace = StringUtils.replace(string, " ".concat(SALESMAN_ID), "/".concat(SALESMAN_ID));
        String replace1 = StringUtils.replace(replace, " ".concat(CUSTOMER_ID), "/".concat(CUSTOMER_ID));
        String replace2 = StringUtils.replace(replace1, " ".concat(SALE_ID), "/".concat(SALE_ID));
        List<String> stringList = Arrays.asList(StringUtils.split(replace2, "/"));
        fileData.addLines(stringList);
    }

    private void checkDataType(String data) {
        if (data.startsWith(SALESMAN_ID)) SalesmanData.addLine(data);
        if (data.startsWith(CUSTOMER_ID)) customerData.addLine(data);
        if (data.startsWith(SALE_ID)) SaleData.addLine(data);
    }
}
