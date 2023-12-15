import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserServiceImpl;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testSaveUser() {
        // Arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto();
        registrationDto.setFirstName("John");
        registrationDto.setLastName("Doe");
        registrationDto.setEmail("john.doe@example.com");
        registrationDto.setPassword("password");

        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
                registrationDto.getEmail(), registrationDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER")));

        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User savedUser = userService.save(registrationDto);

        // Assert
        assertEquals(registrationDto.getFirstName(), savedUser.getFirstName());
        assertEquals(registrationDto.getLastName(), savedUser.getLastName());
        assertEquals(registrationDto.getEmail(), savedUser.getEmail());
        assertEquals(registrationDto.getPassword(), savedUser.getPassword());
    }

    @Test
    public void testLoadUserByUsername() {
        // Arrange
        String email = "john.doe@example.com";
        User user = new User("John", "Doe", email, "password", Collections.singletonList(new Role("ROLE_USER")));

        when(userRepository.findByEmail(email)).thenReturn(user);

        // Act
        UserDetails userDetails = userService.loadUserByUsername(email);

        // Assert
        assertEquals(user.getEmail(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals("ROLE_USER", ((SimpleGrantedAuthority) authorities.iterator().next()).getAuthority());
    }

    @Test
    public void testLoadUserByUsername_InvalidUsername() {
        // Arrange
        String invalidEmail = "nonexistent@example.com";
        when(userRepository.findByEmail(invalidEmail)).thenReturn(null);

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(invalidEmail));
    }
}
