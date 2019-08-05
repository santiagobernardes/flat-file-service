package com.fileservice.features.salesman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SalesmanServiceTest {

    private SalesmanService salesmanService;
    @Mock private SalesmanData salesmanData;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(SalesmanServiceTest.class);
        salesmanService = new SalesmanService(salesmanData);
    }

    @Test
    public void shouldReturnTotalAmount() {
        Mockito.when(salesmanData.getAll()).thenReturn(getSalesmenMock());
        String amountOfSalesmen = salesmanService.amountOfSalesmen();
        Assert.assertEquals(amountOfSalesmen,
                "The TOTAL AMOUNT OF SALESMEN inside the input directory is: 4");
    }

    private List<String> getSalesmenMock() {
        return Arrays.asList(
                "001ç12345678912çDiegoç50000",
                "001ç32456788654çRenatoç40000.99",
                "001ç03647465054çPeçanhaç25000.50",
                "001ç03647465054çPeçanhaç25000.50",
                "001ç03647465054çPeçanhaç25000.50",
                "001ç03650364042çSantiagoç5500.99"
        );
    }
}
