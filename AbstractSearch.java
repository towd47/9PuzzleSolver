import java.util.HashSet;
import java.util.LinkedList;

/* BreadthFirstSearch solves a puzzle using breadth-first search.
 */
public abstract class AbstractSearch {
	protected Puzzle puzzle;
	private HashSet<String> visitedStates;
	private LinkedList<Node> processStates; // queue of puzzle states
	
	public AbstractSearch(Puzzle puzzle) {
		this.puzzle = puzzle;
		Node startingNode = new Node(puzzle.getStateArr());
		processStates = new LinkedList<Node>();
		visitedStates = new HashSet<String>();
		addNode(startingNode);
	}

	public void solvePuzzle() {
		while (!processStates.isEmpty()) {
			Node node = processStates.removeFirst();
			if (processNode(node)) {
				Puzzle.showSolution(node);
				return;
			}
			visitedStates.add(node.getState());
		}
		System.out.println("No solution found.");
	}

	protected final void addNode(Node currNode) {
		processStates.add(currNode);
	}

	// If we haven't visited the puzzle state, add it and return true.
	// The currNode is the parent of the puzzle state.
	protected final boolean maybeAddNode(Node currNode) {
		String state = puzzle.getState(false);
		if (!visitedStates.contains(state)) {
			addNode(new Node(puzzle.getStateArr(), currNode));
			return true;
		} else {
			return false;
		}
	}

	// Tests if the state of the given node is equal to the goal state. If it is, it returns true, otherwise
	// Uses the state of the given node to test if each adjacent state has been visited
	// States that haven't been visited are used to make nodes and are added to the queue
	protected abstract boolean processNode(Node node);
}