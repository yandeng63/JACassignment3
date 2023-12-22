// ----------------------------------------------------- 
// Assignment 3 
// Question: Includes part I and part II 
// Written by: Francis Méthot (0532254), Peng Yang () and Yan Deng ()
// ----------------------------------------------------- 

package SnakeAndLadder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PlaySnakeAndLadder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Setting a maximum attempt to input the number if players.
		final int MAX_ATTEMPTS = 4;

		// Setting the numbers of players that will play.
		System.out.println("Welcome to Snakes and Ladder : The Virtual Game!");
		System.out.println("Created by Yan Deng, Francis Méthot and Peng Yang.");
		Scanner kb = new Scanner(System.in);
		int attempts = 0;
		int numPlayers = 0;

		while (attempts < MAX_ATTEMPTS) {
			System.out.print("Enter the number of players (2-4): ");
			
			try {
			    numPlayers = kb.nextInt();
			} catch (InputMismatchException e) {
			    System.out.println("Invalid input. Please enter a valid integer.");
			    kb.next(); // clear the scanner buffer
			    continue;  // restart the loop
			}

			if (numPlayers >= 2 && numPlayers <= 4) {
				break;
			} else {
				System.out.println("Invalid number of players. Please enter a value between 2 and 4.");
				attempts++;
			}
		}

		if (attempts == MAX_ATTEMPTS) {
			System.out.println("Maximum attempts reached. Exiting.");
			System.exit(0);

		}

		// Starting the game by creating an array list for the players that will be
		// register for the game and assigning them a name
		List<Player> players = new ArrayList<Player>();
		for (int idx = 0; idx < numPlayers; idx++) {
			Player player = new Player("P" + (idx + 1));
			players.add(player);
		}

		// Setting the board with the players on it.
		Board board = new Board(players);
		// Setting the victory condition for the board and changing the turn of each
		// player after they played up until they get a turn each and restart.
		boolean done = false;
		
		int playerIdx = 0;
		while (!done) {
			
			try {
				Player currPlayer = players.get(playerIdx);
				int roll = currPlayer.takeTurn();
				done = board.movePlayer(currPlayer, roll);
				System.out.println("=========\n");
				if (done) {
					System.out.println(
							currPlayer + " has braved the board and successfully climbed on top! CONGRATULATIONS!");

				}
				playerIdx++;
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("IndexOutOfBoundsException: " + e.getMessage());
			}
			
			if (playerIdx == numPlayers) {
				playerIdx = 0;
			}
		}
	kb.close();}
}
