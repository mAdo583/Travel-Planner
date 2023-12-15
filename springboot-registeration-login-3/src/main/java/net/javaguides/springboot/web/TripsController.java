package net.javaguides.springboot.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.City;
import net.javaguides.springboot.model.Country;
import net.javaguides.springboot.model.Place;
import net.javaguides.springboot.model.UserChoices;
import net.javaguides.springboot.service.CityService;
import net.javaguides.springboot.service.CountryService;
import net.javaguides.springboot.service.PlaceService;
import net.javaguides.springboot.service.TripsService;


@RestController
@RequestMapping("/trips")
public class TripsController {
   
    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private PlaceService placeService;

    
    

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getCitiesByCountryId(@RequestParam Long countryId) {
        List<City> cities = cityService.getCitiesByCountryId(countryId);
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/places")
    public ResponseEntity<List<Place>> getPlacesByCityId(@RequestParam Long cityId) {
        List<Place> places = placeService.getPlacesByCityId(cityId);
        return ResponseEntity.ok(places);
    }
    
    @Autowired
    private TripsService tripsService;

    @PostMapping("/saveChoices")
    public ResponseEntity<String> saveUserChoices(
            @RequestParam Long userId,
            @RequestParam Long countryId,
            @RequestParam List<Long> cityIds,
            @RequestParam List<Long> placeIds
    ) {
        tripsService.saveUserChoices(userId, countryId, cityIds, placeIds);
        return ResponseEntity.ok("User choices saved successfully");
    }
    
    @GetMapping("/summary/{userId}")
    public ResponseEntity<UserChoices> getTripSummary(@PathVariable Long userId) {
        Optional<UserChoices> userChoices = tripsService.getUserChoices(userId);

        return userChoices.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
