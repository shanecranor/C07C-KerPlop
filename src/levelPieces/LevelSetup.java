package levelPieces;
import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;



// Contains
public class LevelSetup {
	// Levels have 21 different locations
	// 
	private final static String LEVEL_1 = "DDR D  D S  D S BSHPH";
	private final static String LEVEL_2 = "RSCBC CS    S C S BHH";
	private static Drawable[] currentLevel;
	
	public LevelSetup() {
		
	}
	
	// Create the level
	public void createLevel(int levelNum) {
		if (levelNum == 1) {
			currentLevel = this.toBoard(LEVEL_1);
		} else if (levelNum == 2) {
			currentLevel = this.toBoard(LEVEL_2);
		} else { // Not in Levels
			System.out.print("Attempted to load a level that does not exist");
		}
	}
	
	// Acquires the board
	public Drawable[] getBoard() {
		return currentLevel;
	}
	
	// Acquires the moving pieces
	public ArrayList<Moveable> getMovingPieces() {
		ArrayList<Moveable> out = new ArrayList<Moveable>();
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if(currentLevel[i] instanceof Moveable) {
				out.add((Moveable)currentLevel[i]);
			}
		}
		return out;
	}
	
	// Acquires the interacting pieces
	public ArrayList<GamePiece> getInteractingPieces() {
		ArrayList<GamePiece> out = new ArrayList<GamePiece>();
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (currentLevel[i] instanceof GamePiece) {
				out.add((GamePiece)currentLevel[i]);
			}
		}
		return out;
	}
	
	// Gives the player's starting location
	public int getPlayerStartLoc() {
		return ((GameEngine.BOARD_SIZE - 1) / 2);
	}
	
	// converts level string to drawable arrays
	private Drawable[] toBoard(String lvl) {
		Drawable[] out = new Drawable[GameEngine.BOARD_SIZE];
		for(int i = 0; i < out.length; i++) {
			switch (lvl.charAt(i)) {
				case 'C':
					out[i] = new CSCI406(i);
					break;
				case 'D':
					out[i] = new Dormitory();
					break;
				case 'S':
					out[i] = new CSStudent(i);
					break;
				case 'R':
					out[i] = new PassingReportCard(i);
					break;
				case 'B':
					out[i] = new TestPassed(i);
					break;
			}
		}
		return out;
	}
}
