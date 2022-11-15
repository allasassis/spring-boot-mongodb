package com.allasassis.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.allasassis.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ 
	// o String é porque ele pede o tipo do ID da sua classe, q no caso da User, é string
	
	
	// title = campo pelo qual a gente vai efetuar a busca, ?0 = expressão regular, o primeiro parâmetro que vier no método, se tivesse 2 e 
	//vc quisesse o segundo seria ?1, i = ignora maiusculas e minusculas
	@Query("{ title: { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	// achar pelo titulo qualquer post que contenha o argumento text que você passar, ignorando se é maiuscula ou minuscula
	// ex: http://localhost:8080/posts/titlesearch?text=bom%20dia
}
