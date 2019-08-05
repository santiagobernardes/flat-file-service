package com.fileservice.parser;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DataParserTest {

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(DataParserTest.class);
    }

    @Test
    public void shouldSplitSaleLine() {
        String saleLine = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";
        Triple<String, String, String> expectedSplitedSale =
                Triple.of("10", "Diego", "1-10-100,2-30-2.50,3-40-3.10");

        Triple<String, String, String> splitedSale = DataParser.getSplitedSale(saleLine);

        Assert.assertEquals(expectedSplitedSale, splitedSale);
    }

    @Test
    public void shouldSeparateAllResourcesInLines() {
        List<String> inputLines = Arrays.asList("001ç1234567891234çDiegoç50000 001ç3245678865434çRenatoç40000.99 " +
                "002ç2345675434544345çJose da SilvaçRural",
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");

        List<String> expectedLines = Arrays.asList(
                "001ç1234567891234çDiegoç50000",
                "001ç3245678865434çRenatoç40000.99",
                "002ç2345675434544345çJose da SilvaçRural",
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego"
                );

        List<String> separatedLines = DataParser.breakLines(inputLines);

        Assert.assertEquals(separatedLines, expectedLines);
    }

    @Test
    public void shouldSplitItems() {
        String inputItemsLine = "1-10-100,2-30-2.50,3-40-3.10";

        List<List<String>> expectedSplitedItems = Arrays.asList(
                Arrays.asList("1", "10", "100"),
                Arrays.asList("2", "30", "2.50"),
                Arrays.asList("3", "40", "3.10"));

        List<List<String>> splitedItems = DataParser.getSplitedItems(inputItemsLine);

        Assert.assertEquals(splitedItems, expectedSplitedItems);
    }
}