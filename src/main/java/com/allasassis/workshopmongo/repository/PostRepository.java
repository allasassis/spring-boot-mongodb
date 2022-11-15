package com.allasassis.workshopmongo.repository;

import java.util.Date;
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
	
	// gte: >= (data minima tem que ser >= que a data que chega como parâmetro) e lte: <=
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
	// ex: http://localhost:8080/posts/fullsearch?text=bom&maxDate=2022-11-15
}
