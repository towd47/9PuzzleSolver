/* DepthFirstSearch solves a puzzle using depth-first search.
 */
public class DepthFirstSearch extends AbstractSearch {
	
	public DepthFirstSearch(Puzzle puzzle) {
		super(puzzle);
	}

	protected boolean processNode(Node node) {
		puzzle.initializePuzzle(node.getStateArr());
		if (puzzle.isSolved()) {
			return true;
		}

		if (puzzle.moveBlankLeft()) {
			if (maybeAddNode(node)) {
				return false;
			}
			puzzle.moveBlankRight();
		}

		if (puzzle.moveBlankRight()) {
			if (maybeAddNode(node)) {
				return false;
			}
			puzzle.moveBlankLeft();
		}

		if (puzzle.moveBlankUp()) {
			if (maybeAddNode(node)) {
				return false;
			}
			puzzle.moveBlankDown();
		}

		if (puzzle.moveBlankDown()) {
			if (maybeAddNode(node)) {
				return false;
			}
			puzzle.moveBlankUp();
		}

		addNode(node.previousNode);
		return false;
	}
}
