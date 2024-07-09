package com.MegicalArena;

import java.util.Objects;

public class Player {
	private String name;
	private Integer health;
	private Integer strength;
	private Integer attack;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Player(String name, Integer health, Integer strength, Integer attack) {
		super();
		this.name = Objects.requireNonNull(name, "Name can not be null!!");
		validatePlayer(health, strength, attack);
		this.health = health;
		this.strength = strength;
		this.attack = attack;
	}

	public Player() {

	}

	private void validatePlayer(Integer health, Integer strength, Integer attack) {
		if (health <= 0 || strength <= 0 || attack <= 0) {
            throw new IllegalArgumentException("Health, strength, and attack must be positive integers");
        }		
	}
	
	
	public void reduceHealth(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        this.health = Math.max(0, this.health - damage);
    }
	
	public boolean isAlive() {
        return this.health > 0;
    }

    public int calculateDamage(int diceRoll) {
        return this.attack * diceRoll;
    }

    public int calculateDefense(int diceRoll) {
        return this.strength * diceRoll;
    }
	
	@Override
    public String toString() {
        return String.format("%s [Health: %d, Strength: %d, Attack: %d]", name, health, strength, attack);
    }

}
