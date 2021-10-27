package com.user.service.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.user.service.entities.User;
import com.user.service.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Spy
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Test
	void addUserTest() {
		when(userService.addUser(Mockito.any())).thenReturn(new ResponseEntity<User>(HttpStatus.OK));
		ResponseEntity<User> response = userController.addUser(new User());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
