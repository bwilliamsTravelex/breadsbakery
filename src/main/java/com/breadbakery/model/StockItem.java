package com.breadbakery.model;// Copyright (c) 2018 Travelex Ltd

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockItem {

    private Double quantity;
    private StoreItem item;

}
