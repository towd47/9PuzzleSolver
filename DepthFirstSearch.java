/* DepthFirstSearch solves a puzzle using depth-first search.
 */
public class DepthFirstSearch extends AbstractSearch {
	
	public DepthFirstSearch(Puzzle puzzle) {
		super(puzzle);
	}

	protected boolean processNode(Node node) {
		if (puzzle.isSolved()) {
			System.out.println("The Depth-First search solution is:");
			return true;
		}

		if (tryLeft(node)) {
			return false;
		}
		
		if (tryUp(node)) {
			return false;
		}
		
		if (tryRight(node)) {
			return false;
		}
		
		if (tryDown(node)) {
			return false;
		}
		
		addNode(node.previousNode);
		return false;
	}
}
