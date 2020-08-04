

import java.util.Random;

public class SnakeAndLadder {
	// initializing variable
	int playerPosition;
	int currentPosition;
	int diceRollCount;
	final int WINNING_POINT = 100;
	final int LADDER = 1;
	final int SNAKE = 2;
	final int NO_PLAY = 3;

	// function to get which type of move should player to play
	public int moveType() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}

	// function to get rolledDie
	public int getRollDieNumber() {
		Random random = new Random();
		return random.nextInt(6) + 1;

	}

	// function to get player position
	public void getPlayerPosition() {

		int moveType = moveType();
		int diceNumber = getRollDieNumber();

		// assign player position to current position
		currentPosition = playerPosition;

		System.out.println("move type: " + moveType);
		System.out.println("roll dice Number: " + diceNumber);
		System.out.println("current position: " + currentPosition);

		switch (moveType) {
		case LADDER:
			if (playerPosition + diceNumber > WINNING_POINT) {
				System.out.println("skip !!try again");
			} else {
				playerPosition += diceNumber;
			}

			break;
		case SNAKE:
			playerPosition -= diceNumber;

			break;
		case NO_PLAY:
			System.out.println("you are in same position");
			break;

		}

		System.out.println("player position: " + playerPosition + " " + "Dice Roll count: " + diceRollCount);

		if (playerPosition <= 0) {
			playerPosition = 0;

		}
		 if (playerPosition > WINNING_POINT) {
                                playerPosition = currentPosition;
                        }


	}

	// function to decide player winning
	public void checkPlayerWin() {

		while (playerPosition != WINNING_POINT) {
			getPlayerPosition();
			diceRollCount++;
		}

		if (playerPosition == WINNING_POINT) {
			System.out.println("player won the game!!!" + "number of times dice was played: " + diceRollCount);
		}

	}

	public static void main(String[] args) {

		SnakeAndLadder object = new SnakeAndLadder();
		object.checkPlayerWin();
	}

}
