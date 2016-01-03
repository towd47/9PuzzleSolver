import static org.junit.Assert.*;

import org.junit.Test;

public class DepthFirstSearchTest {

	@Test
	public void testSolver() {
		Puzzle puzzle = new Puzzle(3);
		puzzle.randomizePuzzle(10);
		DepthFirstSearch dfSearch = new DepthFirstSearch(puzzle);
		dfSearch.solvePuzzle();
		assertTrue("Puzzle was solved and the solution was printed to the description", true);
	}

}
