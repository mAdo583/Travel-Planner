package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.City;
import net.javaguides.springboot.repository.CityRepository;

@Service
public class CityService {
   
	
	@Autowired
	private CityRepository cityRepository;
	
	public List<City> getCitiesByCountryId(Long countryId) {
        return cityRepository.findByCountryId(countryId);
    }
	   
	
}
