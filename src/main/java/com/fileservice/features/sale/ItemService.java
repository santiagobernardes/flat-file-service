package com.fileservice.features.sale;

import com.fileservice.features.sale.model.ItemModel;

import java.util.List;

public class ItemService {

    public ItemModel createItemModel(List<String> sale) {
        return new ItemModel(
                Integer.valueOf(sale.get(0)),
                Integer.valueOf(sale.get(1)),
                Double.valueOf(sale.get(2)));
    }
}
