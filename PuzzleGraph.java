import java.util.HashMap;
import java.util.LinkedList;

public class PuzzleGraph {
	private int numNodes;
	private int maxNodes;
	public HashMap<Integer, String> visitedStates;
	public Puzzle puzzle;
	public LinkedList<Node> processStates; 
	
	
	public PuzzleGraph(int maxNodes, int puzzleSize, int randomizeMoves) {
		puzzle = new Puzzle(puzzleSize);
		puzzle.initializePuzzle();
		this.maxNodes = maxNodes;
		numNodes = 0;
		puzzle.randomizePuzzle(randomizeMoves);
		visitedStates = new HashMap<Integer, String>(maxNodes);
		processStates = new LinkedList<Node>();
		Node startingNode = new Node(puzzle.puzzleState);
		visitedStates.put(startingNode.getKey(), puzzle.getState(false));
		processStates.add(startingNode);
	}
}
