import java.util.HashMap;
import java.util.LinkedList;

public class BreadthFirstSearch {
	Puzzle puzzle;
	HashMap<String, Node> visitedStates;
	LinkedList<Node> processStates;
	
	public BreadthFirstSearch(int puzzleSize, int randomizeMoves) {
		puzzle = new Puzzle(puzzleSize);
		puzzle.initializePuzzle();
		puzzle.randomizePuzzle(randomizeMoves);
		processStates = new LinkedList<Node>();
		visitedStates = new HashMap<String, Node>();
		Node startingNode = new Node(puzzle.getStateArr());
		processStates.add(startingNode);
		
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
		if (puzzle.moveBlankLeft()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
			}	
			puzzle.moveBlankRight();
		}
		if (puzzle.moveBlankRight()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
			}		
			puzzle.moveBlankLeft();
		}
		if (puzzle.moveBlankUp()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
			}	
			puzzle.moveBlankDown();
		}
		if (puzzle.moveBlankDown()) {
			String testPuzzState = puzzle.getState(false);
			if (!visitedStates.containsKey(testPuzzState)) {
				Node tempNode = new Node(puzzle.getStateArr(), node);
				processStates.add(tempNode);
			}	
			puzzle.moveBlankUp();
		}
		return false;
	}
}
