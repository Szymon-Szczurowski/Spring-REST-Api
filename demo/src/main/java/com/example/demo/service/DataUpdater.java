package com.example.demo.service;

import com.example.demo.model.interfaces.CustomerRepository;
import com.example.demo.model.interfaces.OrderRepository;
import com.example.demo.model.interfaces.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class DataUpdater {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public DataUpdater(ProductRepository productRepository,
                       CustomerRepository customerRepository,
                       OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Scheduled(cron = "${data.update.cron}")
    public void updateData() {
        String dataUrl = "https://my-api.com/data";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(dataUrl, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // parsowanie pobranych danych i aktualizacja bazy danych
            String data = response.getBody();
            // ...
        }
    }
}