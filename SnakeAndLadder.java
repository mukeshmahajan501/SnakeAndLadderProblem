
import java.util.Random;

public class SnakeAndLadder {
	// initializing variable
	int playerPosition = 0;
	int currentPosition = 0;

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

	// function to decide which type of move player played.
	public void movingPosition() {

		int moveType = moveType();
		int dieNumber = getRollDieNumber();

		// assign player position to current position
		currentPosition = playerPosition;

		System.out.println("move type: " + moveType);
		System.out.println("roll die Number: " + dieNumber);
		System.out.println("current position: " + currentPosition);

		if (moveType == 1) {
			playerPosition += dieNumber;
		} else if (moveType == 2) {
			playerPosition -= dieNumber;

		} else {
			playerPosition = currentPosition;
		}
		System.out.println("player position: " + playerPosition);

		if (playerPosition <= 0) {
			playerPosition = 0;
		}

		if (playerPosition > 100) {
			playerPosition = currentPosition;
		}

	}

	// function to decide player winning
	public void checkPlayerWin() {

		while (playerPosition != 100) {
			movingPosition();
		}

		if (playerPosition == 100) {
			System.out.println("player won the game");
		}

	}

	public static void main(String[] args) {

		SnakeAndLadder object = new SnakeAndLadder();
		object.checkPlayerWin();
	}

}
