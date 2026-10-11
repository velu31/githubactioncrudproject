package com.example.githubdemoaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.githubdemoaction.model.User;
import com.example.githubdemoaction.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public User createUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("User not found: " + id));
	}

	public User updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		User existing = getUserById(id);

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());

        return repository.save(existing);
	}

	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		 User existing = getUserById(id);
	        repository.delete(existing);
		
	}
	
	
	
	
	
	
	
	

}
