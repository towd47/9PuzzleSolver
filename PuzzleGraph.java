import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleGraph {
	private Node[] nodes;
	private int numNodes;
	private int maxNodes;
	private HashMap<Integer, int[][]> visitedNodes;
	
	
	public PuzzleGraph(int maxNodes) {
		this.maxNodes = maxNodes;
		numNodes = 0;
		visitedNodes = new HashMap<Integer, int[][]>(maxNodes);
		
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
			visitedNodes.put(this.key, state);
		}
		
	}
}
