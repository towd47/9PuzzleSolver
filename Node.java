import java.util.ArrayList;

public class Node {
	public int[][] state;
	public int key;
	Node previousNode;
	ArrayList<Node> adjacencyList;

	public Node(int[][] state) {
		this.state = state;
		key = getKey();
		previousNode = null;
	}
	
	public Node(int[][] state, Node previousNode) {
		this.state = state;
		key = getKey();
		this.previousNode = previousNode;
	}

	public int getKey() {
		key = 0;
		for (int i = 0; i < state.length; i++) {
			key = key + (i + 1) * state[i][i];
		}
		return key;
	}
	
	public void printState() {
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				System.out.println(state[i][j]);
				if (j != 2) {
					System.out.println(" ");
				}
			}
			System.out.println("\n");
		}
	}
}
