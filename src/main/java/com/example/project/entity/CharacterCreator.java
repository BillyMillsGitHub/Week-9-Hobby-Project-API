package com.example.project.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity // Table
public class CharacterCreator {
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer id;
	
	@Column(name = "CharacterCreatorName", nullable = false, unique = true)
	private String name;
	
	private String specialAbility;
	
	private Integer power;
	
	private Integer health;
	
	private Integer attack;
	
	private Integer defence;
	
	private Integer agility;
	
	private Integer intelligence;

	public CharacterCreator() {
		super();
		//Required superclass constructor
	}

	public CharacterCreator(String name, String specialAbility, Integer power, Integer health, Integer attack,
			Integer defence, Integer agility, Integer intelligence) {
		super();
		this.name = name;
		this.specialAbility = specialAbility;
		this.power = power;
		this.health = health;
		this.attack = attack;
		this.defence = defence;
		this.agility = agility;
		this.intelligence = intelligence;
		//constructor without ID
	}

	public CharacterCreator(Integer id, String name, String specialAbility, Integer power, Integer health,
			Integer attack, Integer defence, Integer agility, Integer intelligence) {
		super();
		this.id = id;
		this.name = name;
		this.specialAbility = specialAbility;
		this.power = power;
		this.health = health;
		this.attack = attack;
		this.defence = defence;
		this.agility = agility;
		this.intelligence = intelligence;
		//Constructor with ID
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialAbility() {
		return specialAbility;
	}

	public void setSpecialAbility(String specialAbility) {
		this.specialAbility = specialAbility;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefence() {
		return defence;
	}

	public void setDefence(Integer defence) {
		this.defence = defence;
	}

	public Integer getAgility() {
		return agility;
	}

	public void setAgility(Integer agility) {
		this.agility = agility;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}
	//Required getters and setters

	@Override
	public String toString() {
		return "CharacterCreator [id=" + id + ", name=" + name + ", specialAbility=" + specialAbility + ", power="
				+ power + ", health=" + health + ", attack=" + attack + ", defence=" + defence + ", agility=" + agility
				+ ", intelligence=" + intelligence + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agility, attack, defence, health, id, intelligence, name, power, specialAbility);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterCreator other = (CharacterCreator) obj;
		return Objects.equals(agility, other.agility) && Objects.equals(attack, other.attack)
				&& Objects.equals(defence, other.defence) && Objects.equals(health, other.health)
				&& Objects.equals(id, other.id) && Objects.equals(intelligence, other.intelligence)
				&& Objects.equals(name, other.name) && Objects.equals(power, other.power)
				&& Objects.equals(specialAbility, other.specialAbility);
	}
	

}

