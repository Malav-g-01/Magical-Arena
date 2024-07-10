package com.MegicalArena;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {
	@Test
    void testDiceRoll() {
        Dice dice = new Dice();

        // Roll the dice multiple times to ensure it always falls within the expected range
        for (int i = 0; i < 100; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6, "Dice roll should be between 1 and 6");
        }
    }
}
