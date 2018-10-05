package com.breadbakery.handlers;// Copyright (c) 2018 Travelex Ltd

import com.breadbakery.model.StockItem;
import com.breadbakery.model.StockList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class StockHandler {

    @Autowired
    private Map<UUID, StockItem> stock; //Maps the StoreItem id with the StockItem.

    public Optional<StockItem> getStockItemById(UUID id) {
        if (stock.containsKey(id)) {
            return Optional.of(stock.get(id));
        }
        return Optional.empty();
    }

    public StockList getAllStock() {
        StockList stockList = new StockList();
        stockList.setStock(new HashSet<>(stock.values()));
        return stockList;
    }

    public boolean addStock(StockItem stockItem) {
        try {
            stock.put(stockItem.getItem().getId(), stockItem);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

}
