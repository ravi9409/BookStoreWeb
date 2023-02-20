package com.jlcindia.booksearch.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class JLCBookPriceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//enabling swagger-ui
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/METAINF/resources / ");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/METAINF/resources / webjars / ");
    }
}