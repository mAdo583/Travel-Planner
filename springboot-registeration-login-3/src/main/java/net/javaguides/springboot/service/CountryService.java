package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Country;
import net.javaguides.springboot.repository.CountryRepository;

    @Service
    public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
   

    public List<Country> getAllCountries() {   	
    return countryRepository.findAll();
}
}
