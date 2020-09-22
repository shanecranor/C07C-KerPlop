package levelPieces;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.InteractionResult;


// Mobile piece that does NOTHING
public class CSStudent extends GamePiece implements Moveable {
	private final static char SYMBOL = 'S';
	private final static String NAME = "CS Student";
	
	// Constructor
	public CSStudent(int location) {
		super(SYMBOL, NAME, location);
	}
	
	
	// Always has the Interaction Result of None
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE; 
	}
	
	// Moves to a random location on the board
	public void move(Drawable[] gameBoard, int playerLocation) { 
		boolean possible = false;
		int potentialLocation;
		while (!possible) {
			potentialLocation = (int)(Math.random() * (GameEngine.BOARD_SIZE));
			if (gameBoard[potentialLocation] == null && potentialLocation != playerLocation) {
				possible = true;
				int previousLocation = this.getLocation();
				this.setLocation(potentialLocation);
				gameBoard[potentialLocation] = gameBoard[previousLocation];
				gameBoard[previousLocation] = null;
			}
		}
	}
}
