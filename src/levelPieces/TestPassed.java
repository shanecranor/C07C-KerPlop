package levelPieces;
import gameEngine.InteractionResult;
import gameEngine.Drawable;

// Immobile and GET_POINT
public class TestPassed extends GamePiece {
	private final static char SYMBOL = 'B';
	private final static String NAME = "Passed Test";
	
	// Constructor
	public TestPassed(int location) {
		super(SYMBOL, NAME, location);
	}
	
	// Gives a point if at the correct location else nothing
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE; 
	}
}
