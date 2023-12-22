package SnakeAndLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
	// Setting the parameters of the board.
	private final int ROWS = 10;
	private final int COLS = 10;
	private final int NUM_SNAKES = 8;
	private final int NUM_LADDERS = 9;
	// Creating a 2D array for the game board.
	private int[][] gameBoard;
	private int[][] snakes;
	private int[][] ladders;

	// Setting a map so we can apply coordinates on the board and setting our
	// HashMap to be able to place said coordinates on the player currently playing.

	Map<Player, Integer> playerPositions;

	public Board(List<Player> players) {
		// Setting the players to the starting position. I
		this.playerPositions = new HashMap<Player, Integer>();
		for (Player player : players) {
			this.playerPositions.put(player, 0);
		}
		// Setting the board so it becomes a 10x10 array i.e. going from 1 to 100
		gameBoard = new int[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				gameBoard[row][col] = row * ROWS + col + 1;
			}
		}
		// Calling a method to set the snakes and the ladders on the board.
		setSnakes();
		setLadders();
	}

	// Setting the positioning on the board of our players and imposing condition on
	// the board by mainly setting a winning position, a return position if the
	// player goes over the winning position, what happens when you get a snake and
	// a ladder.
	public boolean movePlayer(Player player, int value) {

		int position = playerPositions.get(player);
		position += value;

		if (position == 100) {
			playerPositions.put(player, 100);
			return true;
		}
		if (position > 100) {
			playerPositions.put(player, 96);
			System.out.println("Oups! You overexerted yourself and fell back to 96... Though luck.");
			return false;
		} else {

			try {
				for (int idx = 0; idx < NUM_SNAKES; idx++) {
					if (snakes[idx][0] == position) {
						position = snakes[idx][1];
						playerPositions.put(player, position);

						System.out.println("Bitten by snake, swallowed into the belly of the beast! " + player
								+ " takes a dip back from " + snakes[idx][0] + " to " + snakes[idx][1]);

						return false;
					}
				}
				for (int idx = 0; idx < NUM_LADDERS; idx++) {
					if (ladders[idx][0] == position) {
						position = ladders[idx][1];
						playerPositions.put(player, position);

						System.out.println("You're feeling courageous and take this ladder to the unknown! " + player
								+ " takes a leap from " + ladders[idx][0] + " to " + ladders[idx][1]);

						return false;
					}
				} 
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("IndexOutOfBoundsException: " + e.getMessage());
			}
			playerPositions.put(player, position);
			System.out.println("You are now at " + position);
			return false;
		}

	}

	// Creating the array of the ladders and the snakes with their assigned value on
	// the MAP.
	private void setLadders() {
		// TODO Auto-generated method stub
		ladders = new int[NUM_LADDERS][2];
		ladders[0][0] = 1;
		ladders[0][1] = 38;
		ladders[1][0] = 4;
		ladders[1][1] = 14;
		ladders[2][0] = 9;
		ladders[2][1] = 31;
		ladders[3][0] = 21;
		ladders[3][1] = 42;
		ladders[4][0] = 28;
		ladders[4][1] = 84;
		ladders[5][0] = 36;
		ladders[5][1] = 44;
		ladders[6][0] = 51;
		ladders[6][1] = 67;
		ladders[7][0] = 71;
		ladders[7][1] = 91;
		ladders[8][0] = 80;
		ladders[8][1] = 100;
	}

	private void setSnakes() {
		// TODO Auto-generated method stub
		snakes = new int[NUM_SNAKES][2];

		snakes[0][0] = 16;
		snakes[0][1] = 6;
		snakes[1][0] = 48;
		snakes[1][1] = 30;
		snakes[2][0] = 64;
		snakes[2][1] = 60;
		snakes[3][0] = 79;
		snakes[3][1] = 19;
		snakes[4][0] = 93;
		snakes[4][1] = 68;
		snakes[5][0] = 95;
		snakes[5][1] = 24;
		snakes[6][0] = 97;
		snakes[6][1] = 76;
		snakes[7][0] = 98;
		snakes[7][1] = 78;

	}
}
