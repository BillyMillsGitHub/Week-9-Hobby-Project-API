package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.project.entity.CharacterCreator;
import com.example.project.repo.CharacterCreatorRepo;

@Service
@Primary
public class CharacterCreatorServiceDB implements CharacterCreatorService {
	@Autowired
	private CharacterCreatorRepo repo;

	@Override
	public CharacterCreator getById(int id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

	@Override
	public List<CharacterCreator> getAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public CharacterCreator create(CharacterCreator characterCreator) {
		// TODO Auto-generated method stub
		return this.repo.save(characterCreator);
	}

	@Override
	public CharacterCreator update(Integer id, String name, String specialAbility, Integer power, Integer health,
			Integer attack, Integer defence, Integer agility, Integer intelligence) {
		// TODO Auto-generated method stub
		CharacterCreator toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setName(name);
		if (specialAbility != null)
			toUpdate.setSpecialAbility(specialAbility);
		if (power != null)
			toUpdate.setPower(power);
		if (health != null)
			toUpdate.setHealth(health);
		if (attack != null)
			toUpdate.setAttack(attack);
		if (defence != null)
			toUpdate.setDefence(defence);
		if (agility != null)
			toUpdate.setAgility(agility);
		if (intelligence != null)
			toUpdate.setIntelligence(intelligence);

		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(Integer id) {
		this.repo.deleteById(id);

	}

}
