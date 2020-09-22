package Testing;
import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.CSCI406;
import levelPieces.CSStudent;
import levelPieces.HASS200;
import levelPieces.PassingReportCard;
import levelPieces.TestPassed;


public class TestInteractions {
	
	// Tests that CSCI406 only kills the player when at the same location
	@Test
	public void testCSCI406() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		CSCI406 cs = new CSCI406(10);
		gameBoard[10] = cs;
		// Should kill if on the same space
		assertEquals(InteractionResult.KILL, cs.interact(gameBoard, 10));
		// Ensure no interaction occurs if not on the same space
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i != 10) {
				assertEquals(InteractionResult.NONE, cs.interact(gameBoard,  i));
			}
		}
	}
	
	// Tests that CSStudent never interacts with the player
	@Test
	public void testCSStudent() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		CSStudent student = new CSStudent(10);
		gameBoard[10] = student;
		// Should never interact  no matter where
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, student.interact(gameBoard, i));
		}
	}
	
	// Tests that HASS 200 only hits when the player is within 1 space distance
	@Test
	public void testHASS200() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		HASS200 hass = new HASS200(10);
		gameBoard[10] = hass;
		
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i < 9 || i > 11) { // Should not do anything if out of range
				assertEquals(InteractionResult.NONE, hass.interact(gameBoard,  i));
			} else { // Should hit if in range
				assertEquals(InteractionResult.HIT, hass.interact(gameBoard,  i));
			}
		}
	}
	
	// Tests that PassingReportCard only advances the player when at the same location
	@Test
	public void testPassingReportCard() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		PassingReportCard report = new PassingReportCard(10);
		gameBoard[10] = report;
		// Should advance if on the same space
		assertEquals(InteractionResult.ADVANCE, report.interact(gameBoard, 10));
		// Ensure no interaction occurs if not on the same space
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i != 10) {
				assertEquals(InteractionResult.NONE, report.interact(gameBoard,  i));
			}
		}
	}
	
	// Tests that TestPassed only gives a point when sharing the player's location
	@Test
	public void testTestPassed() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TestPassed test = new TestPassed(10);
		gameBoard[10] = test;
		// Should get a point if on the same space
		assertEquals(InteractionResult.GET_POINT, test.interact(gameBoard, 10));
		// Ensure no interaction occurs if not on the same space
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i != 10) {
				assertEquals(InteractionResult.NONE, test.interact(gameBoard,  i));
			}
		}
	}
}
