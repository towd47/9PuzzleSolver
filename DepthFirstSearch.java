import java.util.HashMap;
import java.util.LinkedList;

/* DepthFirstSearch solves the puzzle using a depth first approach
 * 
 */
public class DepthFirstSearch {
	Puzzle puzzle;
	String solution;
	int totalMoves;
	int randomMoves;
	HashMap<String, Node> visitedStates;
	LinkedList<Node> processStates;

	public DepthFirstSearch(Puzzle puzzle) {
		// Initializes variables
		this.puzzle = puzzle;
		processStates = new LinkedList<Node>();
		Node startingNode = new Node(puzzle.getStateArr());
		processStates.add(startingNode);
		visitedStates = new HashMap<String, Node>();
	}
	
	public void solvePuzzle() {
		// Processes nodes to find solution
		while (!processNode(processStates.getFirst())) {
			visitedStates.put(processStates.getFirst().getState(), processStates.removeFirst());
		}

		// Creates solution string and prints solution to console
		Node tempNode = processStates.getFirst();
		String solution = "";
		int movesToSolve = 0;

		while (tempNode.previousNode != null) {
			solution = tempNode.getState() + "\n" + solution;
			tempNode = tempNode.previousNode;
			movesToSolve++;
		}
		solution = tempNode.getState() + "\n" + solution;
		solution = "The solution is:\n" + solution;
		System.out.print(solution);
		System.out.print("Took " + movesToSolve + " moves to solve puzzle.");
	}

	public boolean processNode(Node node) {
		puzzle.initializePuzzle(node.getStateArr());
		if (puzzle.getState(false).equals(puzzle.goalStateStr)) {
			return true;
		}
		if (puzzle.moveBlankLeft()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
				return false;
			}
			else {
				puzzle.moveBlankRight();
			}
		}
		if (puzzle.moveBlankUp()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
				return false;
			}
			else {
				puzzle.moveBlankDown();
			}
		}
		if (puzzle.moveBlankRight()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
				return false;
			}
			else {
				puzzle.moveBlankLeft();
			}
		}
		if (puzzle.moveBlankDown()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
				return false;
			}
			else {
				puzzle.moveBlankUp();
			}				
		}
		processStates.add(node.previousNode);
		totalMoves--;
		return false;
	}
}
