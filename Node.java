
public class Node {
	int[][] state;
	Node previousNode;

	public Node(int[][] state) {
		this.state = state;
		previousNode = null;
	}
	
	public Node(int[][] state, Node previousNode) {
		this.state = state;
		this.previousNode = previousNode;
	}
	
	public String printState() {
		String currentState = "";
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[0].length; j++) {
				currentState = currentState + state[i][j];
				if (j != state.length - 1) {
					currentState = currentState + " ";
				}
			}
			currentState = currentState + "\n";
		}
		return currentState;
	}
	
	public int[][] getState() {
		int[][] stateCopy = new int[state.length][state[0].length];
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[0].length; j++) {
				stateCopy[i][j] = state[i][j];
			}
		}
		return stateCopy;
	}
}
