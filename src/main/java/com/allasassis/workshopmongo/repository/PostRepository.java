package com.allasassis.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.allasassis.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ 
	// o String é porque ele pede o tipo do ID da sua classe, q no caso da User, é string
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	// achar pelo titulo qualquer post que contenha o argumento text que você passar, ignorando se é maiuscula ou minuscula
	// ex: http://localhost:8080/posts/titlesearch?text=bom%20dia
}
