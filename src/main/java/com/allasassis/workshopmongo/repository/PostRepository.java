package com.allasassis.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.allasassis.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ 
	// o String é porque ele pede o tipo do ID da sua classe, q no caso da User, é string

}
