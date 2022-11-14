package com.allasassis.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allasassis.workshopmongo.domain.User;
import com.allasassis.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id); // aqui estamos usando o findById apenas para aproveitar o tratamento de exceção, caso o id não exista
		repo.deleteById(id);
	}
	
	// Colocaremos o fromDTO no service, porque pode ser que ele precise acessar o banco de dados no futuro, e o repositório está instanciado aqui
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		// esse método converte o UserDTO para um User
	}
}
