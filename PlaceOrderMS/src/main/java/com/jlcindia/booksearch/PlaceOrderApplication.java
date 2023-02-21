package com.jlcindia.booksearch;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class PlaceOrderApplication {
    static Logger log = LoggerFactory.getLogger(PlaceOrderApplication.class);

    public static void main(String args[]) {
        log.info(" PlaceOrderMS - Begin ");
        SpringApplication.run(PlaceOrderApplication.class, args);
        log.info(" PlaceOrderMS - End ");
    }

}
