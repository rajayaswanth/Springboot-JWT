package com.user.service.custombeans;

import java.util.function.Function;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.user.service.entities.User;
import com.user.service.repositories.UserRepository;

@Aspect
@Component
public class CustomBeans {
	
	@Autowired
	UserRepository userRepo;

	@Bean
	public Function<UserDetails, User> fetchUser() {
		return (principal -> {
			String name = principal.getUsername();
			User user = userRepo.findByEmail(name);
			return (user != null) ? user : null;
		});
	}

}
