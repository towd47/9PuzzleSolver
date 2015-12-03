import java.util.HashMap;
import java.util.LinkedList;

public class DepthFirstSearch {
	Puzzle puzzle;
	String solution;
	int totalMoves;
	int randomMoves;
	HashMap<String, Node> visitedStates;
	LinkedList<Node> processStates;

	public DepthFirstSearch(int randomizeMoves, int puzzSize) {
		puzzle = new Puzzle(puzzSize);
		randomMoves = randomizeMoves;
		totalMoves = 0;
		puzzle.initializePuzzle();
		puzzle.randomizePuzzle(randomizeMoves);
		processStates = new LinkedList<Node>();
		Node startingNode = new Node(puzzle.getStateArr());
		processStates.add(startingNode);
		visitedStates = new HashMap<String, Node>();

		while (!createAdjacencyList(processStates.getFirst())) {
			visitedStates.put(processStates.getFirst().printState(), processStates.removeFirst());
		}
		Node tempNode = processStates.getFirst();

		String solution = "";
		int movesToSolve = 0;

		while (tempNode.previousNode != null) {
			solution = tempNode.printState() + "\n" + solution;
			tempNode = tempNode.previousNode;
			movesToSolve++;
		}
		solution = startingNode.printState() + "\n" + solution;
		solution = "The solution is:\n" + solution;
		System.out.print(solution);
		System.out.print("Took " + movesToSolve + " moves to solve puzzle.");
	}

	public boolean createAdjacencyList(Node node) {
		puzzle.initializePuzzle(node.getState());
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
		if (!node.children.isEmpty()) {
			for (int i = 0; i < node.children.size(); i++) {
				visitedStates.remove(node.children.get(i).printState());
			}
		}
		totalMoves--;
		return false;
	}
}
