package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserChoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long countryName;

    @ElementCollection
    @CollectionTable(name = "user_choices_cities", joinColumns = @JoinColumn(name = "user_choices_id"))
    @Column(name = "city_id")
    private List<Long> cityIds;

    @ElementCollection
    @CollectionTable(name = "user_choices_places", joinColumns = @JoinColumn(name = "user_choices_id"))
    @Column(name = "place_id")
    private List<Long> placeIds;

    
    
	public UserChoices() {
		super();
	}

	
	public UserChoices(User user, Long countryName, List<Long> cityIds, List<Long> placeIds) {
		super();
		this.user = user;
		this.countryName = countryName;
		this.cityIds = cityIds;
		this.placeIds = placeIds;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getCountryName() {
		return countryName;
	}

	public void setCountryId(Long countryName) {
		this.countryName = countryName;
	}

	public List<Long> getCityIds() {
		return cityIds;
	}

	public void setCityIds(List<Long> cityIds) {
		this.cityIds = cityIds;
	}

	public List<Long> getPlaceIds() {
		return placeIds;
	}

	public void setPlaceIds(List<Long> placeIds) {
		this.placeIds = placeIds;
	}

    
}

