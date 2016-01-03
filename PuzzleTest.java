import static org.junit.Assert.*;

import org.junit.Test;

public class PuzzleTest {

	@Test
	public void testPuzzleConstructor() {
		Puzzle puzzle = new Puzzle(3);
		assertTrue("Constructor works", true);
		assertTrue("Puzzle has size equal to argument", puzzle.node.state.length == 3 && puzzle.node.state[0].length == 3);
	}
	
	@Test
	public void testRandomizer() { //FOR ADDITIONAL TESTING OF THIS METHOD UNCOMMENT THE SPECIFIED LINE OF THE METHOD
		Puzzle puzzle = new Puzzle(3);
		puzzle.randomizePuzzle(3);
		assertFalse("Puzzle state should be different from the intitial state", puzzle.node.toString().equals("0 1 2\n3 4 5\n6 7 8\n"));
	}
	
	@Test
	public void testIsSolved() {
		Puzzle puzzle = new Puzzle(3);
		assertTrue("the node should have the same state as the goalState",
				puzzle.isSolved());
	}
}
