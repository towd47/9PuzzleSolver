import java.util.HashSet;
import java.util.LinkedList;

/* AbstractSearch implements the code common to BreadthFirstSearch
 * and DepthFirstSearch.
 */
public abstract class AbstractSearch {
	protected Puzzle puzzle;
	private HashSet<String> visitedStates;
	private LinkedList<Node> processStates; // queue of puzzle states

	public AbstractSearch(Puzzle puzzle) {
		this.puzzle = puzzle;
		Node startingNode = new Node(puzzle.node.getStateArr());
		processStates = new LinkedList<Node>();
		visitedStates = new HashSet<String>();
		addNode(startingNode);
	}

	public void solvePuzzle() {
		while (!processStates.isEmpty()) {
			Node node = processStates.removeFirst();
			puzzle = new Puzzle(node);
			if (processNode(node)) {
				Puzzle.showSolution(node);
				return;
			}
			visitedStates.add(node.toString());
		}
		System.out.println("No solution found.");
	}

	protected final void addNode(Node currNode) {
		processStates.add(currNode);
	}

	// If we haven't visited the puzzle state, add it and return true.
	// The currNode is the parent of the puzzle state.
	protected final boolean maybeAddNode(Node currNode) {
		String state = puzzle.node.toString();
		if (!visitedStates.contains(state)) {
			//addNode(new Node(puzzle.node.getStateArr(), currNode));
			addNode(currNode);
			return true;
		} else {
			return false;
		}
	}

	protected boolean tryLeft(Node node) {
		boolean added;
		if (node.moveBlankLeft()) {
			Node newNode = new Node(node.getStateArr(), node);
			added = maybeAddNode(newNode);
			node.moveBlankRight();
			return added;
		}
		return false;
	}

	protected boolean tryUp(Node node) {
		boolean added;
		if (node.moveBlankUp()) {
			Node newNode = new Node(node.getStateArr(), node);
			added = maybeAddNode(newNode);
			node.moveBlankDown();
			return added;
		}
		return false;
	}

	protected boolean tryRight(Node node) {
		boolean added;
		if (node.moveBlankRight()) {
			Node newNode = new Node(node.getStateArr(), node);
			added = maybeAddNode(newNode);
			node.moveBlankLeft();
			return added;
		}
		return false;
	}

	protected boolean tryDown(Node node) {
		boolean added;
		if (node.moveBlankDown()) {
			Node newNode = new Node(node.getStateArr(), node);
			added = maybeAddNode(newNode);
			node.moveBlankUp();
			return added;
		}
		return false;
	}

	// Tests if the state of the given node is equal to the goal state. If it is, it returns true, otherwise
	// Uses the state of the given node to test if each adjacent state has been visited
	// States that haven't been visited are used to make nodes and are added to the queue
	protected abstract boolean processNode(Node node);
}