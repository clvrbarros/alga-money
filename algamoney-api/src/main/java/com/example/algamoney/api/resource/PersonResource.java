package com.example.algamoney.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney.api.event.ResourceCreatedEvent;
import com.example.algamoney.api.model.Person;
import com.example.algamoney.api.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonResource {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Person> list() {
		return personRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, HttpServletResponse response) {
		Person personResult = personRepository.findById(id).orElse(null);
		
		if(personResult == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(personResult);
	}
	
	@PostMapping
	public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
		Person personSaved = personRepository.save(person);
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, personSaved.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personSaved);
	}
	
}
