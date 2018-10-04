package com.breadbakery;// Copyright (c) 2018 Travelex Ltd

import com.breadbakery.handlers.JsonStockLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JsonStockLoader.class, UndertowServlet.class})
public class DemoConfiguration {
}
