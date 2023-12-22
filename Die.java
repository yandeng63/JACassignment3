package SnakeAndLadder;

import java.util.Random;

// This class is to simulate the randomness of a 6 faced die.
public class Die {

	private Random random;

	public Die() {
		random = new Random();
	}

	public int rollD6() {
		return random.nextInt(6) + 1;
	}

}
