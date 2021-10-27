package com.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.customannotations.CurrentUser;
import com.user.service.entities.User;
import com.user.service.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Value("${spring.name}")
	String name;
	
	@Value("${spring.email}")
	String email;
	
	@Value("${spring.phone}")
	String phone;
	
	@Autowired
	UserService userService;

	@PostMapping(value = "/add")
	public ResponseEntity<User> addUser(@RequestBody @Nullable User userRequest) {
		return userService.addUser(userRequest);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userRequest) {
		return userService.updateUser(id, userRequest);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<User>> getUsers() {
		return userService.getUsers();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	@GetMapping(value = "/getLoggedInUser")
	public ResponseEntity<User> getLoggedInUser(@CurrentUser User user) {
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSampleUser")
	public ResponseEntity<User> getSampleUser() {
		User user = new User();
		user.setId(0L);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(phone);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}