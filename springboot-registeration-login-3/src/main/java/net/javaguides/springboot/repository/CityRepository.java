package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	 List<City> findByCountryId(Long countryId);

}
