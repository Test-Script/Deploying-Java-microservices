package com.example.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class OrderApplication {

    @Value("${APP_VERSION:unknown}")
    private String version;

    @Value("${HOSTNAME:local}")
    private String hostname;

    @GetMapping("/")
    public String home() {
        return "Product Service Running";
    }

    @GetMapping("/version")
    public Map<String,String> version() {

        Map<String,String> response = new HashMap<>();

        response.put("service","product-service");
        response.put("version",version);
        response.put("pod",hostname);

        return response;
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}