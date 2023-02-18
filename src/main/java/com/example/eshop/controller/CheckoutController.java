package com.example.eshop.controller;

import com.example.eshop.dto.Purchase;
import com.example.eshop.dto.PurchaseResponse;
import com.example.eshop.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody Purchase purchase) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(checkoutService.saveOrder(purchase));
    }
}