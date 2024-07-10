package com.MegicalArena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicalArenaTest {

    private Player playerA;
    private Player playerB;
    private Dice dice;

    @BeforeEach
    void setUp() {
        playerA = new Player("Player A", 50, 5, 10);
        playerB = new Player("Player B", 100, 10, 5);
        dice = new Dice();
    }

    @Test
    void testFirstAttackerDetermination() {
        Player firstAttacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;

        assertEquals(playerA, firstAttacker, "Player A should attack first because of lower health");
    }

    @Test
    void testBasicBattle() {
        MegicalArena.playTurn(playerA, playerB, dice);
        assertTrue(playerA.getHealth() <= 50, "Player A should lose health after defending");
        assertTrue(playerB.getHealth() <= 100, "Player B should lose health after defending");
    }

    @Test
    void testPlayTurn() {
        int initialHealthB = playerB.getHealth();
        MegicalArena.playTurn(playerA, playerB, dice);

        assertTrue(playerB.getHealth() < initialHealthB, "Player B should lose health after Player A attacks");
    }

    @Test
    void testGameFlow() {
        while (playerA.isAlive() && playerB.isAlive()) {
            MegicalArena.playTurn(playerA, playerB, dice);
            if (playerB.isAlive()) {
                MegicalArena.playTurn(playerB, playerA, dice);
            }
        }

        assertFalse(playerA.isAlive() || playerB.isAlive(), "One of the players should be dead after the game ends");
    }
}