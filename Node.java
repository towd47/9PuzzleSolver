
/* Node is used in the searches to create links between the states
 * to form a tree to find the solution 
 */

public class Node {
	int[][] state;
	Node previousNode;

	//Creates a new node with the given state
	public Node(int[][] state) {
		this.state = state;
		previousNode = null;
	}
	
	//Creates a new node with the given state and sets a pointer to the node this one was reached from
	public Node(int[][] state, Node previousNode) {
		this.state = state;
		this.previousNode = previousNode;
	}
	
	//returns the state of the node in string form
	public String getState() {
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
	
	//Returns a copy of the state stored in the node
	public int[][] getStateArr() {
		int[][] stateCopy = new int[state.length][state[0].length];
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[0].length; j++) {
				stateCopy[i][j] = state[i][j];
			}
		}
		return stateCopy;
	}
}
