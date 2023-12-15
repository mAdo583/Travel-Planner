package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
