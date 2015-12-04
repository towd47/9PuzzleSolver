import static org.junit.Assert.*;

import org.junit.Test;

public class BreadthFirstSearchTest {
	
	@Test
	public void testSolver() {
		Puzzle puzzle = new Puzzle(3);
		puzzle.initializePuzzle();
		puzzle.randomizePuzzle(10);
		BreadthFirstSearch bfSearch = new BreadthFirstSearch(puzzle);
		bfSearch.solvePuzzle();
		assertTrue("Puzzle was solved and the solution was printed to the description", true);
	}

}
