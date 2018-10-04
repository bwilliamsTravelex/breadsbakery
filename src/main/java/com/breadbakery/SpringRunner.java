package com.breadbakery;

import com.breadbakery.handlers.JsonStockLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoConfiguration.class);
    }

}
