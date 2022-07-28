package com.example.project.service;


import java.util.List;
import com.example.project.entity.CharacterCreator;

public interface CharacterCreatorService {

	CharacterCreator getById(int id);

	List<CharacterCreator> getAll();

	CharacterCreator update(Integer id, String name, String specialAbility, Integer power, Integer health, Integer attack, Integer defence, Integer agility, Integer intelligence);
	
	void delete(Integer id);

	CharacterCreator create(CharacterCreator characterCreator);
	
	
}
