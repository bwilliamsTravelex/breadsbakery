package com.breadbakery.handlers;// Copyright (c) 2018 Travelex Ltd

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component
public class StockHandler {

    @Autowired
    private Map<UUID, StockItem> stock;

    public Optional<StockItem> getStockItemById(UUID id) {
        if (stock.containsKey(id)) {
            return Optional.of(stock.get(id));
        }
        return Optional.empty();
    }

    public List<StockItem> getAllStock() {
        return new ArrayList<>(stock.values());
    }

}
