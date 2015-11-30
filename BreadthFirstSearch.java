
public class BreadthFirstSearch {
	PuzzleGraph graph;
	Puzzle puzzle;
	public BreadthFirstSearch(int maxNodes, int puzzleSize, int randomizeMoves) {
		graph = new PuzzleGraph(maxNodes, puzzleSize, randomizeMoves);
		puzzle = new Puzzle(puzzleSize);
		
		while (!createAdjacencyList(graph.processStates.getFirst())) {
			graph.processStates.removeFirst();
		}
		
		Node currentNode = graph.processStates.getLast();
		System.out.println("The solution is:\n");
		while (currentNode.previousNode != null) {
			currentNode.printState();
			currentNode = currentNode.previousNode;
		}
	}
	
	public boolean createAdjacencyList(Node node) {
		puzzle.initializePuzzle(node.state);
		if (puzzle.moveBlankLeft()) {
			String testPuzzState = puzzle.getState(true);
			if (!graph.visitedStates.containsValue(testPuzzState)) {
				Node tempNode = new Node(puzzle.puzzleState, node);
				graph.visitedStates.put(tempNode.getKey(), puzzle.getState(false));
				graph.processStates.add(tempNode);
				if (puzzle.getState(false) == puzzle.getGoalState()) {
					return true;
				}
			}	
			puzzle.moveBlankRight();
		}
		if (puzzle.moveBlankRight()) {
			String testPuzzState = puzzle.getState(true);
			if (!graph.visitedStates.containsValue(testPuzzState)) {
				Node tempNode = new Node(puzzle.puzzleState, node);
				graph.visitedStates.put(tempNode.getKey(), puzzle.getState(false));
				graph.processStates.add(tempNode);
				if (puzzle.getState(false) == puzzle.getGoalState()) {
					return true;
				}
			}	
			puzzle.moveBlankLeft();
		}
		if (puzzle.moveBlankUp()) {
			String testPuzzState = puzzle.getState(true);
			if (!graph.visitedStates.containsValue(testPuzzState)) {
				Node tempNode = new Node(puzzle.puzzleState, node);
				graph.visitedStates.put(tempNode.getKey(), puzzle.getState(false));
				graph.processStates.add(tempNode);
				if (puzzle.getState(false) == puzzle.getGoalState()) {
					return true;
				}
			}	
			puzzle.moveBlankDown();
		}
		if (puzzle.moveBlankDown()) {
			String testPuzzState = puzzle.getState(true);
			if (!graph.visitedStates.containsValue(testPuzzState)) {
				Node tempNode = new Node(puzzle.puzzleState, node);
				graph.visitedStates.put(tempNode.getKey(), puzzle.getState(false));
				graph.processStates.add(tempNode);
				if (puzzle.getState(false) == puzzle.getGoalState()) {
					return true;
				}
			}	
			puzzle.moveBlankUp();
		}
		//puzzle.getState(true);
		return false;
		
	}
}
