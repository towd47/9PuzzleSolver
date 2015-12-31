/* BreadthFirstSearch solves a puzzle using breadth-first search.
 */
public class BreadthFirstSearch extends AbstractSearch {
	
	public BreadthFirstSearch(Puzzle puzzle) {
		super(puzzle);
	}

	// Tests if the state of the given node is equal to the goal state. If it is, it returns true, otherwise
	// Uses the state of the given node to test if each adjacent state has been visited
	// States that haven't been visited are used to make nodes and are added to the queue
	protected boolean processNode(Node node) {
		puzzle.initializePuzzle(node.getStateArr());
		if (puzzle.isSolved()) {
			return true;
		}

		if (puzzle.moveBlankLeft()) {
			maybeAddNode(node);
			puzzle.moveBlankRight();
		}

		if (puzzle.moveBlankRight()) {
			maybeAddNode(node);
			puzzle.moveBlankLeft();
		}

		if (puzzle.moveBlankUp()) {
			maybeAddNode(node);
			puzzle.moveBlankDown();
		}

		if (puzzle.moveBlankDown()) {
			maybeAddNode(node);
			puzzle.moveBlankUp();
		}

		return false;
	}
}
