package com.breadbakery.model;// Copyright (c) 2018 Travelex Ltd

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreItem {

    private String name;
    private Double price;
    private UUID id;
    private ItemType type;
}
