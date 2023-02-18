package com.example.eshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "customer")
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        if(order != null) {
            orders.add(order);
            order.setCustomer(this);
        }
    }
}
