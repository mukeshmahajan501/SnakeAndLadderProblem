package com.test;

import java.util.Random;

public class SnakeAndLadder {
	int numOfPlayer = 4;
	int playerPositionArray[] = new int[numOfPlayer];

	int START_POSITION = 0;
	final int NO_PLAY = 1;
	final int LADDER = 2;
	final int SNAKE = 3;
	final int WINING_POINT = 100;
	int position = 0;
	int currentPosition = 0;

	public void setPlayerPosition() {
		for (int i = 0; i < playerPositionArray.length; i++) {
			playerPositionArray[i] = 0;
		}

	}

	public int getDiceRoll() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

	public int getMoveType() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}

	public void playing() {

		for (int i = 0; i < playerPositionArray.length; i++) {
			int diceNumber = getDiceRoll();
			int moveType = getMoveType();

			switch(moveType)
			{
			case NO_PLAY:
				System.out.println("no play");
				break;
			case LADDER:

				if (playerPositionArray[i] > WINING_POINT) {
					System.out.println("you can't move!!");

				} else {
					playerPositionArray[i] = playerPositionArray[i] + diceNumber;
					System.out.println("you got ladder move forword");

						playing();

				}
				break;
			case SNAKE:
				playerPositionArray[i] = playerPositionArray[i] - diceNumber;

				if (playerPositionArray[i] < 0) {
					playerPositionArray[i] = START_POSITION;
				}
				break;

			}
			System.out.println(playerPositionArray[i]);
		}

	}

	int winTurn = 0;

	public void checkWinPlayer() {
		while (winTurn != 1) {
			for (int i = 0; i < playerPositionArray.length; i++) {

				System.out.println("players turn: " + i);
				playing();

				if (playerPositionArray[i] == WINING_POINT) {
					winTurn = 1;
					System.out.println("player " + (i + 1)+" win");
					break;
				}

			}
		}

		for (int i = 0; i < playerPositionArray.length; i++) {

			System.out.println("current postion of player: " + (i + 1) + " " + playerPositionArray[i]);

		}
	}

	public static void main(String[] args) {
		SnakeAndLadder object = new SnakeAndLadder();

		object.checkWinPlayer();
	}

}


