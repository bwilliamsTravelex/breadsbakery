package com.breadbakery;// Copyright (c) 2018 Travelex Ltd

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.breadbakery"})
@ComponentScan("com")
@Configuration
public class UndertowServlet {

    @Value("${port}")
    private Integer port;

    @Bean
    public UndertowEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory() {
        final UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();

        factory.addBuilderCustomizers((UndertowBuilderCustomizer) builder -> builder.addHttpListener(port, "localhost"));

        return factory;
    }

}
