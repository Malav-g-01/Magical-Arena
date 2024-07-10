package com.MegicalArena;

public class MegicalArena {
	public static void main(String[] args) {
		Player playerA = new Player("Player A", 50, 5, 10);
		Player playerB = new Player("Player B", 100, 10, 5);
		Dice dice = new Dice();

		Player attacker = new Player();
		Player defender = new Player();

		// the player with less health starts first
		if (playerA.getHealth() > playerB.getHealth()) {
			attacker = playerB;
			defender = playerA;
		} else {
			attacker = playerA;
			defender = playerB;
		}

		while (playerA.isAlive() && playerB.isAlive()) {
			playTurn(attacker, defender, dice);
			if (defender.isAlive()) {
				playTurn(defender, attacker, dice);
			}
		}

		Player winner = playerA.isAlive() ? playerA : playerB;
		Player loser = playerA.isAlive() ? playerB : playerA;
		System.out.println(loser.getName() + " has been defeated. " + winner.getName() + " wins!");
	}

	// will compute the damage given to defender
	protected static void playTurn(Player attacker, Player defender, Dice dice) {
		int attackDiceRoll = dice.roll();
		int defenseDiceRoll = dice.roll();

		int attackDamage = attacker.calculateDamage(attackDiceRoll);
		int defenseDamage = defender.calculateDefense(defenseDiceRoll);

		int damageDealt = Math.max(0, attackDamage - defenseDamage);
		defender.reduceHealth(damageDealt);
	}
}
