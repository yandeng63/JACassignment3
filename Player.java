package SnakeAndLadder;

import java.util.Scanner;

public class Player {
	// This class is to make the interaction with the dice for each player on their
	// turn.

	private String name;
	private static Die die;
	Scanner kb = new Scanner(System.in);

	public Player(String name) {
		die = new Die();

		this.name = name;

	}

	public int takeTurn() {

		System.out.println(name + "'s turn. Please press enter to roll the dice.");
		kb.nextLine();

		int roll = die.rollD6();

		System.out.println(name + " rolled " + roll + ".");

		return roll;
		}

	public String toString() {
		return name;
	}
}