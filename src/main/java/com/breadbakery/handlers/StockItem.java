package com.breadbakery.handlers;// Copyright (c) 2018 Travelex Ltd

import com.breadbakery.model.StoreItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockItem {

    private Double quantity;
    private StoreItem item;

}
