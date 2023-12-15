package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.UserChoices;
import net.javaguides.springboot.repository.UserChoicesRepository;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class TripsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserChoicesRepository userChoicesRepository;

    public void saveUserChoices(Long userId, Long countryId, List<Long> cityIds, List<Long> placeIds) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            UserChoices userChoices = new UserChoices();
            userChoices.setUser(user);
            userChoices.setCountryId(countryId);
            userChoices.setCityIds(cityIds);
            userChoices.setPlaceIds(placeIds);

            userChoicesRepository.save(userChoices);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    public Optional<UserChoices> getUserChoices(Long userId) {
        return userChoicesRepository.findById(userId);
    }
    
  
}
