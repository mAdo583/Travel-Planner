package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/regist")
public class UserRegistrationController {
	 
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "regist";
	}
	
	
	@PostMapping
    public RedirectView registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, RedirectAttributes attributes) {
        userService.save(registrationDto);
        attributes.addFlashAttribute("successMessage", "Registration successful!");
        return new RedirectView("redirect:/regist?success");
    }

}
