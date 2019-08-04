//package com.fileservice.features.customer;
//
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
//public class CustomerServiceTest {
//
//    private CustomerService customerService;
//    @Mock private CustomerData customerData;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(CustomerServiceTest.class);
//        customerService = new CustomerService(customerData);
//    }
//
//    @Test
//    public void shouldReturnTotalAmount() {
//        Mockito.when(customerData.getAll()).thenReturn(getCustomersMock());
//        String amountOfCustomers = customerService.amountOfCustomers();
//        Assert.assertEquals(amountOfCustomers,
//                "The TOTAL AMOUNT OF CUSTOMERS inside de input directory is: 4");
//    }
//
//    private List<String> getCustomersMock() {
//        return List.of(
//                "002ç2345675434544345çJose da SilvaçRural",
//                "002ç2345675433444345çEduardo PereiraçRural",
//                "002ç2345675433441221çMarcelo PeçanhaçFinanças",
//                "002ç2345675433441221çMarcelo PeçanhaçFinanças",
//                "002ç2345675433441221çMarcelo PeçanhaçFinanças",
//                "002ç2345675433441221çMarcelo PeçanhaçFinanças",
//                "002ç9999975433444345çVolmir BernardesçFaço tudo"
//                );
//    }
//}