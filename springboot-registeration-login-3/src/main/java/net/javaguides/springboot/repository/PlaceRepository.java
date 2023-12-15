package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long>{
	 List<Place> findByCityId(Long cityId);
}
