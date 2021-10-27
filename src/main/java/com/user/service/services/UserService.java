package com.user.service.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.user.service.entities.User;

public interface UserService {
	
	public ResponseEntity<User> addUser(User userRequest);
	
	public ResponseEntity<List<User>> getUsers();

	public ResponseEntity<?> updateUser(Long id, User userRequest);

	public ResponseEntity<?> deleteUser(Long id);

}
