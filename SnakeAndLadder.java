
import java.util.Random;

public class SnakeAndLadder {
	// initializing variable
	int position = 0;
	final int NO_PLAY = 1;
	final int SNAKE = 2;
	final int LADDER = 3;
	final int START_POSITION = 0;

	// function to get dice number between 1 to 6
	public static int getDiceNumber() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

	// function to get number between 1 to 3
	public static int typeOfMove() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}

	// check for player position
	public void checkPlayerPosition() {
		while (position != 100) {

			int diceNumber = getDiceNumber();
			int moveType = typeOfMove();

			System.out.println("dice number: " + diceNumber);
			System.out.println("move type: " + moveType);
			switch (moveType) {
			case NO_PLAY:
				position = position;
				break;
			case SNAKE:
				position = (position - diceNumber);

				break;
			case LADDER:
				position = (position + diceNumber);

				break;
			}

			// if position is minus then assign 0
			if (position <= 0) {
				position = START_POSITION;
			}

			System.out.println("player position:" + position);
		}
		// checking matching condition
		if (position == 100) {
			System.out.println("player won the game!!!!");
		}

	}

	public static void main(String[] args) {
		SnakeAndLadder object = new SnakeAndLadder();
		object.checkPlayerPosition();
	}

}
