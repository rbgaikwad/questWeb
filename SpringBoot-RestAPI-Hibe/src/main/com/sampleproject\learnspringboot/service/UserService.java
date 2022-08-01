package com.sampleproject.learnspringboot.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sampleproject.learnspringboot.exception.UserAlreadyExistException;
import com.sampleproject.learnspringboot.model.Address;
import com.sampleproject.learnspringboot.model.User;

public interface UserService extends UserDetailsService {

	User addUser(User user) throws UserAlreadyExistException;

	List<User> listAllUsers();

	void deleteUserById(Integer Id);

	Address createAddress(Integer userId, Address address);

	Address updateUserAddress(long address_id, Address address);
}
