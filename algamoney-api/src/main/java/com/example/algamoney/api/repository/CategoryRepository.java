package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Category;

//Jpa needs to know the Entity and the type of the primary key 
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
