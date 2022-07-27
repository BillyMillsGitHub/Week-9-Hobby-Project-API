package com.example.project.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.CharacterCreator;

@Repository
public interface CharacterCreatorRepo extends JpaRepository<CharacterCreator, Integer> {

	CharacterCreator findByNameStartingWithIgnoreCase(String name);
}

