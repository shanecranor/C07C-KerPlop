package levelPieces;
import gameEngine.InteractionResult;
import gameEngine.Drawable;


// Immobile and ADVANCE
public class PassingReportCard extends GamePiece {
	private final static char SYMBOL = 'R';
	private final static String NAME = "Passing Report Card";
	
	// Constructor
	public PassingReportCard(int location) {
		super(SYMBOL, NAME, location);
	}
	
	// Advances if at the correct location else nothing
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE; 
	}
}
