package Testing;

import static org.junit.Assert.fail;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.CSStudent;
import levelPieces.Dormitory;
import levelPieces.HASS200;

public class TestMovingPieces {
	/*
	 * Tests random motion, used by both the Sniper and Unicorn.
	 * Strategy: 
	 * - Place pieces in all spaces EXCEPT 0, 6, 12, 13, 20.
	 * - Ensures both end spots (0 and 20) are open.
	 * - Same piece is used in all spaces, as piece identity doesn't matter.
	 * - Set player location to space 13.
	 * - Call move function many times, ensure each open space is chosen
	 *   (13 is "open" but has the player, so it should NOT be chosen)
	 */
	@Test
	public void testCSStudentMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Dormitory();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Dormitory();
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Dormitory();
		CSStudent s = new CSStudent(6);
		gameBoard[6] = s;
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		for (int i=0; i <40000; i++) {
			s.move(gameBoard, 13);
			int loc = s.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 12 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count0 > 1);
		assert(count6 > 1);
		assert(count12 > 1);
		assert(count20 > 1);		
	}
	@Test
	public void testHASS200Movement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 3, leaves 0-2 open
		for (int i=3;i<=5; i++)
			gameBoard[i] = new Dormitory();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Dormitory();
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Dormitory();
		HASS200 h = new HASS200(0);
		gameBoard[0] = h;
		//test movement left to right + obstacle jumping
		assert(h.getLocation() == 0);
		h.doMove(gameBoard, 13);
		assert(h.getLocation() == 1);
		assert(gameBoard[0] == null);
		h.doMove(gameBoard, 13);
		assert(h.getLocation() == 2);
		assert(gameBoard[1] == null);
		h.doMove(gameBoard, 13);
		
		assert(h.getLocation() == 6); //JUMPs over obstacles
		assert(gameBoard[2] == null);
		h.doMove(gameBoard, 13);
		
		assert(h.getLocation() == 12); //JUMPs over obstacles
		assert(gameBoard[6] == null);
		h.doMove(gameBoard, 13);
		assert(h.getLocation() == 12); //should stay still next to player
		assert(gameBoard[6] == null);
		h.doMove(gameBoard, 13);
		//move right to left
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 3, leaves 0-2 open
		for (int i=3;i<=5; i++)
			gameBoard[i] = new Dormitory();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Dormitory();
		// Leave 12, 13 and 19-20 open, assume player in 2
		for (int i=14; i<19; i++)
			gameBoard[i] = new Dormitory();
		h = new HASS200(20);
		gameBoard[20] = h;
		//test movement left to right + obstacle jumping
		assert(h.getLocation() == 20);
		h.doMove(gameBoard, 2);
		assert(h.getLocation() == 19);
		assert(gameBoard[20] == null);
		h.doMove(gameBoard, 2);
		assert(h.getLocation() == 13);
		assert(gameBoard[19] == null);
		h.doMove(gameBoard, 2);
		
		assert(h.getLocation() == 12); //JUMPs over obstacles
		assert(gameBoard[13] == null);
		h.doMove(gameBoard, 2);
		
		assert(h.getLocation() == 6); //JUMPs over obstacles
		assert(gameBoard[12] == null);
		h.doMove(gameBoard, 2);
		assert(h.getLocation() == 6); //should stay next to obstacles touching player
		assert(gameBoard[12] == null);
		h.doMove(gameBoard, 2);
	}
}
