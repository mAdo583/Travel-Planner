package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Place;
import net.javaguides.springboot.repository.PlaceRepository;

@Service
public class PlaceService {
   
	
	
	@Autowired
	private PlaceRepository placeRepository;
	
	 public List<Place> getPlacesByCityId(Long cityId) {
	        return placeRepository.findByCityId(cityId);
	    }
}
