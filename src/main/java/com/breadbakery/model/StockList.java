package com.breadbakery.model;// Copyright (c) 2018 Travelex Ltd

import lombok.Data;

import java.util.Set;

@Data
public class StockList {

    public Set<StockItem> stock;

}
