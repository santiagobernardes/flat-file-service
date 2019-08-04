package com.fileservice.features;

import lombok.Getter;

@Getter
public enum DataEnum {
    SALESMAN("001"),
    CUSTOMER("002"),
    SALE("003");

    final String id;

    DataEnum(String id) {
        this.id = id;
    }
}
