package levelPieces;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.InteractionResult;


// Mobile piece that does NOTHING
public class CSStudent extends GamePiece implements Moveable {
	private final static char SYMBOL = 'S';
	private final static String NAME = "CS Student";
	
	public CSStudent(int location) {
		super(SYMBOL, NAME, location);
	}
	
	
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE; 
	}
	
	// Moves to a random location on the board
	public void move(Drawable[] gameBoard, int playerLocation) { 
		final int MIN = 0;
		boolean possible = false;
		int potentialLocation;
		while (!possible) {
			potentialLocation = (int)(Math.random() * (GameEngine.BOARD_SIZE - MIN + 1) + MIN);
			if (gameBoard[potentialLocation] == null) {
				possible = true;
				this.setLocation(potentialLocation);
			}
		}
	}
}
