package com.MegicalArena;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
	@Test
	void testPlayerInitialization() {
		Player player = new Player("Player A", 50, 5, 10);

		assertEquals("Player A", player.getName(), "Player name should be 'Player A'");
		assertEquals(50, player.getHealth(), "Player health should be 50");
		assertEquals(5, player.getStrength(), "Player strength should be 5");
		assertEquals(10, player.getAttack(), "Player attack should be 10");
	}

	@Test
	void testPlayerHealthReduction() {
		Player player = new Player("Player A", 50, 5, 10);
		player.reduceHealth(20);

		assertEquals(30, player.getHealth(), "Player health should be reduced to 30 after taking 20 damage");
	}

	@Test
	void testPlayerIsAlive() {
		Player player = new Player("Player A", 50, 5, 10);

		assertTrue(player.isAlive(), "Player should be alive initially");

		player.reduceHealth(50);
		assertFalse(player.isAlive(), "Player should be dead after health is reduced to 0");
	}

	@Test
	void testPlayerCalculateDamage() {
		Player player = new Player("Player A", 50, 5, 10);
		int damage = player.calculateDamage(4);

		assertEquals(40, damage, "Player damage should be 40 for dice roll of 4 with attack 10");
	}

	@Test
	void testPlayerCalculateDefense() {
		Player player = new Player("Player A", 50, 5, 10);
		int defense = player.calculateDefense(3);

		assertEquals(15, defense, "Player defense should be 15 for dice roll of 3 with strength 5");
	}

	@Test
	void testInvalidPlayerAttributes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			new Player("Player A", -10, 5, 10);
		});
		assertEquals("Health, strength, and attack must be positive integers", thrown.getMessage(),
				"Invalid health should throw an exception");

		thrown = assertThrows(IllegalArgumentException.class, () -> {
			new Player("Player A", 50, -5, 10);
		});
		assertEquals("Health, strength, and attack must be positive integers", thrown.getMessage(),
				"Invalid strength should throw an exception");

		thrown = assertThrows(IllegalArgumentException.class, () -> {
			new Player("Player A", 50, 5, -10);
		});
		assertEquals("Health, strength, and attack must be positive integers", thrown.getMessage(),
				"Invalid attack should throw an exception");
	}
}
