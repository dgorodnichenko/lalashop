package com.example.eshop.services;

import com.example.eshop.dto.Purchase;
import com.example.eshop.dto.PurchaseResponse;
import com.example.eshop.entities.Customer;
import com.example.eshop.entities.Order;
import com.example.eshop.entities.OrderItem;
import com.example.eshop.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CustomerRepository customerRepository;

    @Transactional
    public PurchaseResponse saveOrder(Purchase purchase) {
        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.addItem(item));

        Customer customer = purchase.getCustomer();

        String email = customer.getEmail();

        Customer customerFromDb = customerRepository.findCustomerByEmail(email);
        if (customerFromDb != null) {
            customer = customerFromDb;
        }

        customer.addOrder(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
