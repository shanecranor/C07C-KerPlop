package levelPieces;
import gameEngine.Drawable;

public class Dormitory implements Drawable {
	private final static char SYMBOL = 'D';
	
	// Constructor
	public Dormitory() {
		
	}
	
	// Defines what to print for location
	public void draw() {
		System.out.print(SYMBOL);
	}
}
