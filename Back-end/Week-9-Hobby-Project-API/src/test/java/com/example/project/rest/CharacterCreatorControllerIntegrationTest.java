package com.example.project.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.project.entity.CharacterCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Sql(scripts = { "classpath:CharacterCreator_schema.sql",
		"classpath:CharacterCreator_data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
public class CharacterCreatorControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	private int add(int a, int b) {
		return a + b;
	}

	@Test
	void testDemo() {
		assertEquals(2, add(1, 1));
	}

	@Test
	void testCreate() throws Exception {
		CharacterCreator testCharacterCreator = new CharacterCreator("Magman", "Fireball", 5000, 950, 1100, 850, 1500,
				2100);
		String testCharacterCreatorAsJSON = this.mapper.writeValueAsString(testCharacterCreator);
		RequestBuilder req = post("/createCharacterCreator").content(testCharacterCreatorAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		CharacterCreator createdCharacterCreator = new CharacterCreator("Magman", "Fireball", 5000, 950, 1100, 850,
				1500, 2100);
		String createdCharacterCreatorAsJSON = this.mapper.writeValueAsString(createdCharacterCreator);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdCharacterCreatorAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeCharacterCreator/1")).andExpect(status().isNoContent());
	}
}
