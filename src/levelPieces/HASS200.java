package levelPieces;
import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.InteractionResult;

// HITS through objects and moves toward player (can be blocked) (Interacts at a distance)
public class HASS200 extends GamePiece implements Moveable {
	private final static char SYMBOL = 'H';
	private final static String NAME = "HASS200";
	
	public HASS200(int location) {
		super(SYMBOL, NAME, location);
	}
	
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(playerLocation - this.getLocation()) < 2) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE; 
	}
	public void move(Drawable[] gameBoard, int playerLocation) {
		int currentLocation = this.getLocation();
		if(Math.random() < 0.5) { //only move 50% of the time
			if(currentLocation > playerLocation) {
				currentLocation--;
			} else {
				currentLocation++;
			}
			if (gameBoard[currentLocation] == null) { //if we can't move, don't
				this.setLocation(currentLocation);
			}
		}
	}
}
