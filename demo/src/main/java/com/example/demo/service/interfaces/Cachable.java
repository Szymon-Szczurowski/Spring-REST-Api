package com.example.demo.service.interfaces;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import org.springframework.cache.annotation.Cacheable;


import java.util.List;


public interface Cachable {
    @Cacheable("products")
    List<Product> findAllProducts();

    @Cacheable("customers")
    List<Customer> findAllCustomers();

    @Cacheable("orders")
    List<Order> findAllOrders();
}
