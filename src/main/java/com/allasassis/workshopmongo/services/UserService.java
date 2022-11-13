package com.allasassis.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allasassis.workshopmongo.domain.User;
import com.allasassis.workshopmongo.repository.UserRepository;
import com.allasassis.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired	// autowired praticamente instancia o objeto sozinho
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
}
