package com.fileservice.features.sale;

import com.fileservice.features.sale.model.ItemModel;
import com.fileservice.features.sale.model.SaleModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SaleServiceTest {

    private SaleService saleService;
    @Mock private SaleData saleData;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(SaleServiceTest.class);
        saleService = new SaleService(saleData);
    }

    @Test
    public void shouldReturnWorstSalesman() {
        Mockito.when(saleData.getAll()).thenReturn(getMockSaleList());
        String worstSalesmanEver = saleService.worstSalesmanEver();
        Assert.assertEquals(worstSalesmanEver,
                "THE WORST SALESMAN EVER is Diego, who billed only R$ 1199.0");
    }

    @Test
    public void shouldReturnMostExpensiveSale() {
        Mockito.when(saleData.getAll()).thenReturn(getMockSaleList());
        String mostExpensiveSale = saleService.mostExpensiveSale();
        Assert.assertEquals(mostExpensiveSale,
                "The sale with the ID 01 is the MOST EXPENSIVE one - R$ 340053.5 - and it was made by Santiago");
    }

    @Test
    public void shouldReturnMessageWhenCallingMostExpensiveSale() {
        Mockito.when(saleData.getAll()).thenReturn(getEmptyMockSaleList());
        String mostExpensiveSale = saleService.mostExpensiveSale();
        Assert.assertEquals(mostExpensiveSale,
                "THE SYSTEM WASN'T ABLE TO FIND ANY REGISTERED SALE IN THE INPUT DIRECTORY");
    }

    @Test
    public void shouldReturnMessageWhenCallingWorstSalesman() {
        Mockito.when(saleData.getAll()).thenReturn(getEmptyMockSaleList());
        String worstSalesmanEver = saleService.worstSalesmanEver();
        Assert.assertEquals(worstSalesmanEver,
                "THE SYSTEM WASN'T ABLE TO FIND ANY REGISTERED SALE IN THE INPUT DIRECTORY");
    }

    private List<String> getMockSaleList() {
        return Arrays.asList(
                "003ç01ç[1-34-10000,2-33-1.50,3-40-0.10]çSantiago",
                "003ç02ç[1-34-1,2-33-1]çRenato",
                "003ç03ç[1-10-100,2-30-2.50,3-40-3.10]çDiego",
                "003ç04ç[1-34-1000,2-33-1.50,3-40-0.10]çRenato");
    }

    private List<String> getEmptyMockSaleList() {
        return Collections.emptyList();
    }
}
