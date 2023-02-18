package com.example.eshop.dto;

import com.example.eshop.entities.Customer;
import com.example.eshop.entities.Order;
import com.example.eshop.entities.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Order order;
    private Set<OrderItem> orderItems;
}
