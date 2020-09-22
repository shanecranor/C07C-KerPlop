package levelPieces;
import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.InteractionResult;
import gameEngine.GameEngine;

// HITS through objects and moves toward player (can be blocked) (Interacts at a distance)
public class HASS200 extends GamePiece implements Moveable {
	private final static char SYMBOL = 'H';
	private final static String NAME = "HASS200";
	
	public HASS200(int location) {
		super(SYMBOL, NAME, location);
	}
	
	// Hits if within range else nothing
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(playerLocation - this.getLocation()) < 2) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE; 
	}
	
	// Will generally move in the player's direction
	public void move(Drawable[] gameBoard, int playerLocation) {
		if(Math.random() < 0.5) { //only move 50% of the time
			doMove(gameBoard, playerLocation);
		}
	}
	
	public void doMove(Drawable[] gameBoard, int playerLocation) {
		int currentLocation = this.getLocation();
		if(currentLocation > playerLocation) {
			while (currentLocation >= 0 && gameBoard[currentLocation] != null && currentLocation != playerLocation) {
				currentLocation--;
			}
		} else {
			while (currentLocation < GameEngine.BOARD_SIZE && gameBoard[currentLocation] != null && currentLocation != playerLocation) {
				currentLocation++;
			}
		}
		if (currentLocation >= 0 && currentLocation < GameEngine.BOARD_SIZE && currentLocation != playerLocation) { //if we can't move, don't
			int previousLocation = this.getLocation();
			this.setLocation(currentLocation);
			gameBoard[currentLocation] = gameBoard[previousLocation];
			gameBoard[previousLocation] = null;
		}
	}
}
