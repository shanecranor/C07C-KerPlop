package levelPieces;
import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;



// Contains
public class LevelSetup {
	// Levels have 21 different locations
	// 
	private final static String LEVEL_1 = {};
	private final static String LEVEL_2 = {};
	private static Drawable[] currentLevel;
	
	public LevelSetup() {
		
	}
	
	// Create the level
	public void createLevel(int LevelNum) {
		if (LevelNum == 1) {
			currentLevel = LEVEL_1;
		} else if (LevelNum == 2) {
			currentLevel = LEVEL_2;
		} else { // Not in Levels
			System.out.print("Attempted to load a level that does not exist");
		}
	}
	
	public Drawable[] getBoard() {
		
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		
	}
	
	public int getPlayerStartLoc() {
		return ((GameEngine.BOARD_SIZE - 1) % 2);
	}
}
