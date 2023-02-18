package com.example.eshop.services;

import com.example.eshop.entities.Order;
import com.example.eshop.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getOrdersByEmail(String email) {
        return orderRepository.findOrdersByCustomerEmail(email);
    }
}
