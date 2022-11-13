package com.allasassis.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allasassis.workshopmongo.domain.User;
import com.allasassis.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)	// também pode usar @GetMapping, é a mesma coisa
	public ResponseEntity<List<User>> findAll() {	// ResponseEntity encapsula toda uma estrutura necessária pra gente retornar respostas http já com possíveis cabeçalhos e erros
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
