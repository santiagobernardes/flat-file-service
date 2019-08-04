package com.fileservice.features.sale.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemModel {
    private Integer id;
    private Integer quantity;
    private Double price;
}
