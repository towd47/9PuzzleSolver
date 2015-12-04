import static org.junit.Assert.*;

import org.junit.Test;

public class PuzzleTest {

	@Test
	public void testPuzzleConstructor() {
		Puzzle puzzle = new Puzzle(3);
		assertTrue("Constructor works", true);
		assertTrue("Puzzle has size equal to argument", puzzle.puzzleState.length == 3 && puzzle.puzzleState[0].length == 3);
	}
	
	@Test
	public void testInitializerAndGetState() {
		Puzzle puzzle = new Puzzle(3);
		puzzle.initializePuzzle();
		assertEquals("Puzzle should be initialized to the goal state", puzzle.getState(false), "0 1 2\n3 4 5\n6 7 8\n"); //Tests getState()
		assertTrue("blankRow and blankCol should both be initialized to 0", puzzle.blankRow == 0 && puzzle.blankCol == 0);
	}

	@Test
	public void testInitializerWithArgumentAndGetState() {
		Puzzle puzzle = new Puzzle(3);
		int[][] testState = new int[][] {{3, 2, 1}, {5, 8, 6}, {4, 7, 0}};
		puzzle.initializePuzzle(testState);
		assertEquals("Puzzle should be initialized to the goal state", puzzle.getState(false), "3 2 1\n5 8 6\n4 7 0\n");
		assertTrue("blankRow and blankCol should both be initialized to the location of the 0", puzzle.blankRow == 2 && puzzle.blankCol == 2);
	}
	
	@Test
	public void testRandomizer() { //FOR ADDITIONAL TESTING OF THIS METHOD UNCOMMENT THE SPECIFIED LINE OF THE METHOD
		Puzzle puzzle = new Puzzle(3);
		puzzle.initializePuzzle();
		puzzle.randomizePuzzle(3);
		assertFalse("Puzzle state should be different from the intitial state", puzzle.getState(false).equals(puzzle.goalStateStr));
	}
	
	@Test
	public void testMoveBlankLeft() {
		Puzzle puzzle = new Puzzle(3);
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		puzzle.initializePuzzle(testState);
		assertTrue("moveBlankLeft should return true if the blank moved left", puzzle.moveBlankLeft());
		assertEquals("The 3 and 0 should have swapped in the puzzle state", puzzle.getState(false), "1 4 2\n0 3 5\n6 7 8\n");
		assertFalse("moveBlankLeft should return false if the blank cant move left", puzzle.moveBlankLeft());
	}

	@Test
	public void testMoveBlankRight() {
		Puzzle puzzle = new Puzzle(3);
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		puzzle.initializePuzzle(testState);
		assertTrue("moveBlankRight should return true if the blank moved right", puzzle.moveBlankRight());
		assertEquals("The 3 and 0 should have swapped in the puzzle state", puzzle.getState(false), "1 4 2\n3 5 0\n6 7 8\n");
		assertFalse("moveBlankRight should return false if the blank cant move right", puzzle.moveBlankRight());
	}

	@Test
	public void testMoveBlankUp() {
		Puzzle puzzle = new Puzzle(3);
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		puzzle.initializePuzzle(testState);
		assertTrue("moveBlankUp should return true if the blank moved up", puzzle.moveBlankUp());
		assertEquals("The 3 and 0 should have swapped in the puzzle state", puzzle.getState(false), "1 0 2\n3 4 5\n6 7 8\n");
		assertFalse("moveBlankUp should return false if the blank cant move up", puzzle.moveBlankUp());
	}

	@Test
	public void testMoveBlankDown() {
		Puzzle puzzle = new Puzzle(3);
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		puzzle.initializePuzzle(testState);
		assertTrue("moveBlankDown should return true if the blank moved down", puzzle.moveBlankDown());
		assertEquals("The 3 and 0 should have swapped in the puzzle state", puzzle.getState(false), "1 4 2\n3 7 5\n6 0 8\n");
		assertFalse("moveBlankDown should return false if the blank cant move down", puzzle.moveBlankDown());
	}
	
	@Test
	public void testGetStateArr() {
		Puzzle puzzle = new Puzzle(3);
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		puzzle.initializePuzzle(testState);
		int[][] comparer = puzzle.getStateArr();
		for (int i = 0; i < puzzle.puzzleState.length; i++) {
			for (int j = 0; j < puzzle.puzzleState.length; j++) {
				assertEquals("getStateArr should return the same array as the array the puzzle was initialized with", 
						comparer[i][j], puzzle.puzzleState[i][j]);
			}
		}
	}
	
	@Test
	public void testGetGoalState() {
		Puzzle puzzle = new Puzzle(3);
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		puzzle.initializePuzzle(testState);
		assertEquals("the goalStateStr created by getGoalState in the initializer should be the goalState",
				puzzle.goalStateStr, "0 1 2\n3 4 5\n6 7 8\n");
	}
}
