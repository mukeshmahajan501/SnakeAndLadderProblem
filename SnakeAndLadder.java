import java.util.Random;

public class SnakeAndLadder {
	// initializing variable
	int postion = 0;

	// function to get dice number between 1 to 6
	public static int getDiceNumber() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

	public static void main(String[] args) {
		int result = getDiceNumber();
		System.out.println("Dice number: "+result);
	}

}
