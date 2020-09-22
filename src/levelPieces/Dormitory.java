package levelPieces;
import gameEngine.Drawable;

public class Dormitory implements Drawable {
	private final static char SYMBOL = 'D';
	public void draw() {
		System.out.print(SYMBOL);
	}
}
