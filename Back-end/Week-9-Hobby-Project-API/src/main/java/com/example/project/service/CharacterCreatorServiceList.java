package com.example.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project.entity.CharacterCreator;

@Service
public abstract class CharacterCreatorServiceList implements CharacterCreatorService {

	private List<CharacterCreator> characterCreator;

	@Override
	public CharacterCreator getById(Integer id) {
		return this.characterCreator.get(id);

	}

	@Override
	public List<CharacterCreator> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharacterCreator create(CharacterCreator characterCreator) {
		this.characterCreator.add(characterCreator);
		return this.characterCreator.get(this.characterCreator.size() - 1);

	}

	@Override
	public CharacterCreator update(Integer id, String name, String specialAbility, Integer power, Integer health,
			Integer attack, Integer defence, Integer agility, Integer intelligence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
