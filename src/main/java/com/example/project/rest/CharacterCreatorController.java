package com.example.project.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.project.entity.CharacterCreator;
import com.example.project.service.CharacterCreatorService;

@CrossOrigin
@RestController

public class CharacterCreatorController {



	@Autowired
	private CharacterCreatorService service; // dependency




	@GetMapping("/getCharacterCreator")
	public ResponseEntity<List<CharacterCreator>> getAll() {
		return new ResponseEntity<List<CharacterCreator>>(this.service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/getCharacterCreatorById/{id}")
//	public ResponseEntity<CharacterCreator> getById(@PathVariable int id) {
//		return new ResponseEntity<CharacterCreator>(this.service.getById(id), HttpStatus.OK);
	public CharacterCreator getById(@PathVariable int id) {
		return this.service.getById(id);

}

	@PostMapping("/createCharacterCreator")
	public ResponseEntity<CharacterCreator> create(@RequestBody CharacterCreator characterCreator) {

		System.out.println("Created: " + characterCreator);
		CharacterCreator created = this.service.create(characterCreator);
		return new ResponseEntity<CharacterCreator>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/updateCharacterCreator/{id}")
	public CharacterCreator update(@PathVariable Integer id, @PathParam("name") String name, @PathParam("specialAbility") String specialAbility,
			@PathParam("power") Integer power, @PathParam("health") Integer health, @PathParam("attack") Integer attack, @PathParam("defence") Integer defence, 
			@PathParam("agility") Integer agility, @PathParam("intelligence") Integer intelligence){
		return this.service.update(id, name, specialAbility, power, health, attack, defence, agility, intelligence );

	}
	

	// id = 1

	@DeleteMapping("/removeCharacterCreator/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		System.out.println("ID: " + id);
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}