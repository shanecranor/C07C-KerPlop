package levelPieces;
import gameEngine.InteractionResult;
import gameEngine.Drawable;

// Immobile and Kills
public class CSCI406 extends GamePiece {
	private final static char SYMBOL = 'C';
	private final static String NAME = "CSCI406";
	
	// Constructor
	public CSCI406(int location) {
		super(SYMBOL, NAME, location);
	}
	
	// Kills if at the correct location else nothing
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE; 
	}
}
