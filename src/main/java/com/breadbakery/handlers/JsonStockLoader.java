package com.breadbakery.handlers;// Copyright (c) 2018 Travelex Ltd

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Configuration
public class JsonStockLoader {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Value("${stock.path.location}")
    private String resourceLocation;

    @Autowired
    private ResourcePatternResolver resourceResolver;

    @Bean(name = "stock")
    public Map<UUID, StockItem> createStockMap() throws IOException {
        HashMap<UUID, StockItem> returnMap = new HashMap<>();
        Resource resource = resourceResolver.getResource("classpath:/" + resourceLocation);
        Set<StockItem> storeItems = objectMapper.readValue(resource.getURL(), new TypeReference<Set<StockItem>>(){});
        storeItems.forEach(storeItem -> returnMap.put(storeItem.getItem().getId(), storeItem));
        return returnMap;
    }

}
