import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleGraph {
	private int numNodes;
	private int maxNodes;
	private HashMap<Integer, int[][]> visitedStates;
	public Puzzle puzzle;
	
	
	public PuzzleGraph(int maxNodes, int puzzleSize) {
		puzzle = new Puzzle(puzzleSize);
		this.maxNodes = maxNodes;
		numNodes = 0;
		visitedStates = new HashMap<Integer, int[][]>(maxNodes);
		
	}
	class Node {
		private int[][] state;
		private int key;
		ArrayList<Node> adjacencyList;
		private Boolean encountered;
		
		public Node(int[][] state) {
			this.state = state;
			key = 0;
			for (int i = 0; i < state.length; i++) {
				key = key + (i + 1) * state[i][i];
			}
			visitedStates.put(this.key, this.state);
		}
		
		public void createAdjacencyList(Node node) {
			puzzle.initializePuzzle(node.state);
			
		}
		
	}
}
