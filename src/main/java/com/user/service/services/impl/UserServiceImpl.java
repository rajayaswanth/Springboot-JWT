package com.user.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.service.entities.User;
import com.user.service.exceptions.BadRequestException;
import com.user.service.exceptions.NotFoundException;
import com.user.service.exceptions.ValidationError;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	@CacheEvict(value = "users", allEntries = true)
	public ResponseEntity<User> addUser(User userRequest) {
		User user = userRepo.findByEmail(userRequest.getEmail());
		if(user == null) {
			userRequest.setPassword(encoder.encode(userRequest.getPassword()));
			return new ResponseEntity<User>(userRepo.save(userRequest), HttpStatus.OK);
		}
		List<ValidationError> errors = new ArrayList<ValidationError>();
		ValidationError error = new ValidationError("Email", "user with email - " + userRequest.getEmail() + " already exist's");
		errors.add(error);
		throw new BadRequestException("User with email already exist's", errors);
	}

	@Override
	@Cacheable(value = "users")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userRepo.findAll(), HttpStatus.OK);
	}

	@Override
	@CacheEvict(value = "users", allEntries = true)
	public ResponseEntity<?> updateUser(Long id, User userRequest) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			user.get().setEmail(userRequest.getEmail());
			user.get().setName(userRequest.getName());
			return new ResponseEntity<User>(userRepo.save(user.get()), HttpStatus.OK);
		}
		List<ValidationError> errors = new ArrayList<ValidationError>();
		ValidationError error = new ValidationError("id", "user with id - " + id + " doesn't exist");
		errors.add(error);
		throw new NotFoundException("User doesn't exist", errors);
	}

	@Override
	@CacheEvict(value = "users", allEntries = true)
	public ResponseEntity<?> deleteUser(Long id) {
		userRepo.deleteById(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
