package com.allasassis.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allasassis.workshopmongo.domain.Post;
import com.allasassis.workshopmongo.repository.PostRepository;
import com.allasassis.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired	// autowired praticamente instancia o objeto sozinho
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
}
