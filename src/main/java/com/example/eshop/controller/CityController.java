package com.example.eshop.controller;

import com.example.eshop.entities.City;
import com.example.eshop.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/city/{code}")
    public ResponseEntity<List<City>> getCitiesByCountryId(@PathVariable String code) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cityService.getCitiesByCountryCode(code));
    }
}
