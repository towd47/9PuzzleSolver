import java.util.HashMap;
import java.util.LinkedList;

/* BreadthFirstSearch solves a puzzle using the breadthFirstSearch style
 * It takes an int puzzle size to define the size of the puzzle
 * and an int randomizeMoves to define how randomized the puzzle is
 * The search creates a new puzzle, randomizes it, and then 
 */

public class BreadthFirstSearch {
	Puzzle puzzle;
	HashMap<String, Node> visitedStates;
	LinkedList<Node> processStates; // Used a linked list as a simple queue
	
	public BreadthFirstSearch(Puzzle puzzle) {
		// Initializes variables
		this.puzzle = puzzle;
		processStates = new LinkedList<Node>();
		visitedStates = new HashMap<String, Node>();
		Node startingNode = new Node(puzzle.getStateArr());
		processStates.add(startingNode);
	}
	
	public void solvePuzzle() {
		
		// Creates nodes for each state until the the goalstate is found and a node is created with it
				while (!processNode(processStates.getFirst())) {
					visitedStates.put(processStates.getFirst().getState(), processStates.removeFirst());
				}
				
				// Creates a string of the solution using the final node and its previousNode 
				// variable to trace the path back to the starting state
				Node tempNode = processStates.getFirst();
				String solution = "";
				int movesToSolve = 0;
				
				while (tempNode.previousNode != null) {
					solution = tempNode.getState() + "\n" + solution;
					tempNode = tempNode.previousNode;
					movesToSolve++;
				}
				
				solution = "The solution is:\n" + tempNode.getState() + "\n" + solution + "Took " + movesToSolve + " moves to solve puzzle.";
				System.out.println(solution);
	}
	
	// Tests if the state of the given node is equal to the goal state. If it is, it returns true, otherwise
	// Uses the state of the given node to test if each adjacent state has been visited
	// States that haven't been visited are used to make nodes and are added to the queue
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
