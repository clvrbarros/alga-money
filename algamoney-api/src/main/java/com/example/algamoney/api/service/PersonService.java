package com.example.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Person;
import com.example.algamoney.api.repository.PersonRepository;

@Service
public class PersonService { 
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person update(Long id, Person person) {
		Person savedPerson = personRepository.findById(id).orElse(null);
		if (savedPerson == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(person, savedPerson, "id");
		return personRepository.save(savedPerson);
	}
}
