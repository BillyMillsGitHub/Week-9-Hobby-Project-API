package com.example.project.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.project.entity.CharacterCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:CharacterCreator_Schema.sql",
				"classpath:CharacterCreator_Data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CharacterCreatorControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;



	@Test
	void testCreate() throws Exception {
		CharacterCreator testCharacterCreator = new CharacterCreator("Magboy", "Waterball", 5000, 950, 1100, 850, 1500,
				2100); //mock data entry
		String testCharacterCreatorAsJSON = this.mapper.writeValueAsString(testCharacterCreator);
		RequestBuilder req = post("/createCharacterCreator").content(testCharacterCreatorAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		CharacterCreator createdCharacterCreator = new CharacterCreator(4, "Magboy", "Waterball", 5000, 950, 1100, 850,
				1500, 2100);
		
		String createdCharacterCreatorAsJSON = this.mapper.writeValueAsString(createdCharacterCreator);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdCharacterCreatorAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}


	

	@Test
	void testReadById() throws Exception {
		CharacterCreator readCharactercreator = new CharacterCreator (1, "Magman", "Fireball", 5000, 950, 1100, 850, 1500, 2100);
		String createdCharactorCreatorAsJSON = this.mapper.writeValueAsString(readCharactercreator);
		
		this.mvc.perform(get("/getCharacterCreatorById/1")).andExpect(content().json(createdCharactorCreatorAsJSON)).andExpect(status().isOk());
	}
	 
	
//	@Test
//	void testReadByAll() throws Exception {
//		
//		List<CharacterCreator> readCharacterCreators = new ArrayList<>();
//		readCharacterCreators.add(new CharacterCreator(1, "Magman", "Fireball", 5000, 950, 1100, 850, 1500, 2100));
//		String createdCharacterCreatorAsJSON = this.mapper.writeValueAsString(readCharacterCreators);
//		this.mvc.perform(get("/getCharacterCreator")).andExpect(content().json(createdCharacterCreatorAsJSON)).andExpect(status().isOk());
//		
//	}
	
	@Test
	void readByID() throws Exception {
		CharacterCreator readCharacterCreator = new CharacterCreator(1, "Magman", "Fireball", 5000, 950, 1100, 850, 1500, 2100);
		String createdCharacterCreatorAsJSON = this.mapper.writeValueAsString(readCharacterCreator);
		this.mvc.perform(get("/getCharacterCreatorById/1")).andExpect(content().json(createdCharacterCreatorAsJSON)).andExpect(status().isOk());
		
	}
		
//	@Test
//	void testUpdate() throws Exception {
//		CharacterCreator updateCharacterCreator = new CharacterCreator(1, "Mag", "Fireball", 5000, 950, 1100, 850, 1500, 2100);
//		String toJSON = this.mapper.writeValueAsString(updateCharacterCreator);
//		ResultMatcher checkBody = MockMvcResultMatchers.content().json(toJSON);
//		
//		this.mvc.perform(patch("/updateCharacterCreator/1").content(toJSON).contentType(MediaType.APPLICATION_JSON)).andExpect(checkBody)
//		.andExpect(status().isOk());
//	}

	
	
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeCharacterCreator/1")).andExpect(status().isNoContent());
	}


	
	
}

