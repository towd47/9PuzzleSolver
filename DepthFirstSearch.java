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
			visitedStates.put(startingNode.printState(), processStates.removeFirst());
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
		String testPuzzState = puzzle.getState(false);
		if (!visitedStates.containsKey(testPuzzState) && totalMoves < randomMoves && puzzle.moveBlankLeft()) {
			Node tempNode = new Node(puzzle.getStateArr(), node);
			processStates.add(tempNode);
			totalMoves++;
		}
		else if (!visitedStates.containsKey(testPuzzState) && totalMoves < randomMoves  && puzzle.moveBlankUp()) {
			Node tempNode = new Node(puzzle.getStateArr(), node);
			processStates.add(tempNode);
			totalMoves++;
		}
		else if (!visitedStates.containsKey(testPuzzState) && totalMoves < randomMoves  && puzzle.moveBlankRight()) {
			Node tempNode = new Node(puzzle.getStateArr(), node);
			processStates.add(tempNode);
			totalMoves++;
		}
		else if (!visitedStates.containsKey(testPuzzState) && totalMoves < randomMoves  && puzzle.moveBlankDown()) {
			Node tempNode = new Node(puzzle.getStateArr(), node);
			processStates.add(tempNode);
			totalMoves++;
		}
		else {
			processStates.add(node.previousNode);
			totalMoves--;
		}
		return false;
	}
}
