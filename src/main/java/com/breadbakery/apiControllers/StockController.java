package com.breadbakery.apiControllers;// Copyright (c) 2018 Travelex Ltd

import com.breadbakery.handlers.StockHandler;
import com.breadbakery.model.StockItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockHandler stockHandler;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<StockItem>> getStock() {
        log.info("Get All Stock request has been made, returning all Stock.");
        return ResponseEntity.ok(stockHandler.getAllStock());
    }

    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<StockItem> getStockItem(@PathVariable final UUID id) {
        log.info("Get stock item with id {} request has been made, attempting to return item.", id);
        Optional<StockItem> stockItemOptional =  stockHandler.getStockItemById(id);
        if (stockItemOptional.isPresent()) {
            return ResponseEntity.ok(stockItemOptional.get());
        } else {
            log.error("Get stock item with id {} cannot be found, returning 404", id);
            return ResponseEntity.notFound().build();
        }
    }
}

