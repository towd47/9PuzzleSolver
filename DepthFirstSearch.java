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
		if (puzzle.movesRandomized != - 1) {
			randomMoves = puzzle.movesRandomized;
		}
		else {
			randomMoves = 1000; // If puzzle was initialized to a state, the moves used to randomize it are unknown
		}
		totalMoves = 0;
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
		if (totalMoves <= randomMoves && puzzle.moveBlankLeft()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
				tempNode.previousNode.addChild(tempNode);
				totalMoves++;
				return false;
			}
			else {
				puzzle.moveBlankRight();
			}
		}
		if (totalMoves <= randomMoves && puzzle.moveBlankUp()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
				tempNode.previousNode.addChild(tempNode);
				totalMoves++;
				return false;
			}
			else {
				puzzle.moveBlankDown();
			}
		}
		if (totalMoves <= randomMoves && puzzle.moveBlankRight()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
				tempNode.previousNode.addChild(tempNode);
				totalMoves++;
				return false;
			}
			else {
				puzzle.moveBlankLeft();
			}
		}
		if (totalMoves <= randomMoves && puzzle.moveBlankDown()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
				tempNode.previousNode.addChild(tempNode);
				totalMoves++;
				return false;
			}
			else {
				puzzle.moveBlankUp();
			}				
		}
		processStates.add(node.previousNode);
		//Because the moves before trying a different path were also limited by the moves used to randomize puzzle
		//To avoid errors I had to mark some already visited states as not visited so they could still be searched through
		//In a different order. Only the first child in a tested direction is marked as visited
		if (!node.children.isEmpty()) {
			for (int i = 0; i < node.children.size(); i++) {
				visitedStates.remove(node.children.get(i).getState());
			}
		}
		totalMoves--;
		return false;
	}
}
