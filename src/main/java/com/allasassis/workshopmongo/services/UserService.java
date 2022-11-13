package com.allasassis.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allasassis.workshopmongo.domain.User;
import com.allasassis.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired	// autowired praticamente instancia o objeto sozinho
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	
}
