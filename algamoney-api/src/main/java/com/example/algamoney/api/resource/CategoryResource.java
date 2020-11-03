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
import com.example.algamoney.api.model.Category;
import com.example.algamoney.api.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Category> list() {
		return categoryRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Category> create(@Valid @RequestBody Category category, HttpServletResponse response) {
		Category categorySaved = categoryRepository.save(category);
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, categorySaved.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, HttpServletResponse response) {
		Category resultCategory = categoryRepository.findById(id).orElse(null);
		
		if(resultCategory == null) {
			return ResponseEntity.notFound().build();
		} 
		
		return ResponseEntity.ok().body(resultCategory);
	}
}
