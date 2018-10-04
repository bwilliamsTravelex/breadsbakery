package com.breadbakery.apiControllers;// Copyright (c) 2018 Travelex Ltd

import com.breadbakery.handlers.StockHandler;
import com.breadbakery.handlers.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockHandler stockHandler;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<StockItem>> getStock() {
        return ResponseEntity.ok(stockHandler.getAllStock());
    }

    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<StockItem> getStockItem(@PathVariable final UUID id) {
        Optional<StockItem> stockItemOptional =  stockHandler.getStockItemById(id);
        if (stockItemOptional.isPresent()) {
            return ResponseEntity.ok(stockItemOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

