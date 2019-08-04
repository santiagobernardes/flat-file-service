//package com.fileservice.features.sale;
//
//import com.fileservice.features.sale.model.SaleModel;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.List;
//
//@RunWith(MockitoJUnitRunner.class)
//public class SaleServiceTest {
//
//    private SaleService saleService;
//    @Mock private SaleData saleData;
//    @Mock private ItemService itemService;
//
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(SaleServiceTest.class);
//        saleService = new SaleService(saleData, itemService);
//    }
//
//    @Test
//    public void shouldReturnWorstSalesman(){
//    }
//
//    @Test
//    public void shouldReturnMostExpensiveSale() {
//    }
//
//    public static List<SaleModel> getMockSaleModelList() {
//        return List.of(new SaleModel("01", List.of(), "Santiago", 1000.0));
//    }
//}
