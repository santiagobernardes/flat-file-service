//package com.fileservice.writer;
//
//import com.fileservice.features.customer.CustomerService;
//import com.fileservice.features.sale.SaleService;
//import com.fileservice.features.salesman.SalesmanService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.List;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DataWriterTest {
//
//    private DataWriter dataWriter;
//    @Mock private CustomerService customerService;
//    @Mock private SalesmanService salesmanService;
//    @Mock private SaleService saleService;
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(DataWriterTest.class);
//        dataWriter = new DataWriter(customerService, salesmanService, saleService);
//    }
//
//    @Test
//    public void shouldCreateOutputContent() {
//        final String amountOfCustomers = "The TOTAL AMOUNT OF CUSTOMERS inside de input directory is: 2";
//        final String amountOfSalesmen = "The TOTAL AMOUNT OF SALESMEN inside de input directory is: 2";
//        final String mostExpensiveSale = "The sale with the ID 10 is the MOST EXPENSIVE one - R$ 1199.0 - and it was made by Diego";
//        final String worstSalesmanEver = "THE WORST SALESMAN EVER is Renato, who billed only R$ 787.0";
//
//        Mockito.when(customerService.amountOfCustomers()).thenReturn(amountOfCustomers);
//        Mockito.when(salesmanService.amountOfSalesmen()).thenReturn(amountOfSalesmen);
//        Mockito.when(saleService.mostExpensiveSale()).thenReturn(mostExpensiveSale);
//        Mockito.when(saleService.worstSalesmanEver()).thenReturn(worstSalesmanEver);
//
//        List<String> outputData = dataWriter.writeOutput();
//
//        Assert.assertEquals(outputData, List.of(amountOfCustomers, amountOfSalesmen, mostExpensiveSale, worstSalesmanEver));
//    }
//
//}