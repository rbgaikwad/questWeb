package com.sampleproject.learnspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampleproject.learnspringboot.exception.UserAlreadyExistException;
import com.sampleproject.learnspringboot.model.Address;
import com.sampleproject.learnspringboot.model.User;
import com.sampleproject.learnspringboot.service.UserService;

@RestController
@RequestMapping("/api/users")
public class MainController {

	@Autowired
	private UserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserAlreadyExistException {
		try {
			User newUser = userService.addUser(user);
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/setAddress/{userId}")
	public ResponseEntity<Address> setAddress(@PathVariable(value = "userId") Integer userId, @RequestBody Address address) {
		try {
			Address setAddress = userService.setAddress(userId, address);
			return new ResponseEntity<>(setAddress, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAll")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> responseListUsers = userService.listAllUsers();
		return new ResponseEntity<>(responseListUsers, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<HttpStatus> delete(@PathVariable(value = "userId") Integer userId) {
		try {
			userService.deleteUserById(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
