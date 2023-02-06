package com.example.eshop.services;

import com.example.eshop.entities.City;
import com.example.eshop.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getCitiesByCountryCode(String code) {
        return cityRepository.findAllByCountryCode(code);
    }
}
