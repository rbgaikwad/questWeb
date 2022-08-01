package com.sampleproject.learnspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sampleproject.learnspringboot.exception.UserAlreadyExistException;
import com.sampleproject.learnspringboot.model.Address;
import com.sampleproject.learnspringboot.model.User;
import com.sampleproject.learnspringboot.repository.AddressRepository;
import com.sampleproject.learnspringboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AddressRepository addressRepo;
	
	@Override
	public User addUser(User user) throws UserAlreadyExistException {
		
		//let's check if user already registered in the system
		if(checkIfUserExist(user.getEmail())) {
			throw new UserAlreadyExistException("User already exists for this email");
		}
		
		User newUser = userRepo.save(user);
		//List<String> roles = new ArrayList<>();
		//roles.add("USER");
		//user.setRoles(roles);
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		 return newUser;
	}
	
	public boolean checkIfUserExist(String email) {
        return userRepo.findByEmail(email) != null ? true : false;
    }

	@Override
	public List<User> listAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUserById(Integer Id) {
		userRepo.deleteById(Id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public Address setAddress(Integer userId, Address address) {
		Optional<User> user = userRepo.findByUserId(userId);
		if(user.isPresent()) {
			address.setUser(user.get());
			return addressRepo.save(address);
		}
		return null;
	}


}
