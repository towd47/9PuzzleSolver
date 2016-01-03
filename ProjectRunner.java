
public class ProjectRunner {

	public static void main(String[] args) {
		Puzzle puzzle = new Puzzle(3);
		puzzle.randomizePuzzle(5);
		BreadthFirstSearch bfSearch = new BreadthFirstSearch(puzzle);
		DepthFirstSearch dfSearch = new DepthFirstSearch(puzzle);
		bfSearch.solvePuzzle();
		dfSearch.solvePuzzle();
	}

}
