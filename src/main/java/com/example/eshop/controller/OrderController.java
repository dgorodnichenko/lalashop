package com.example.eshop.controller;

import com.example.eshop.entities.Order;
import com.example.eshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(@RequestParam String email) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.getOrdersByEmail(email));
    }
}
