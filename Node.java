
/* Node is used in the searches to create links between the states
 * to form a tree to find the solution 
 */

public class Node {
	int[][] state;
	Node previousNode;
	private int blankRow;
	private int blankCol;

	public Node(int size) {
		int currentVal = 0;
		state = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				state[row][col] = currentVal;
				currentVal++;
			}
		}
		blankRow = 0;
		blankCol = 0;
	}
	
	//Creates a new node with the given state
	public Node(int[][] state) {
		this.state = state;
		previousNode = null;
		for (int row = 0; row < state.length; row++) {
			for (int col = 0; col < state[0].length; col++) {
				if (state[row][col] == 0) {
					blankRow = row;
					blankCol = col;
					break;
				}
			}
		}
	}
	
	//Creates a new node with the given state and sets a pointer to the node this one was reached from
	public Node(int[][] state, Node previousNode) {
		this.state = state;
		this.previousNode = previousNode;
		for (int row = 0; row < state.length; row++) {
			for (int col = 0; col < state[0].length; col++) {
				if (state[row][col] == 0) {
					blankRow = row;
					blankCol = col;
					break;
				}
			}
		}
	}
	
	public String toString() {
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
	
	//Swaps the zero representing the blank with the space to the left or returns false if the zero has no spaces to the left
	public boolean moveBlankLeft() {
		if (blankCol != 0) {
			state[blankRow][blankCol] = state[blankRow][blankCol - 1];
			state[blankRow][blankCol - 1] = 0;
			blankCol--;
			return true;
		}
		return false;
	}

	//Swaps the zero representing the blank with the space to the right or returns false if the zero has no spaces to the right
	public boolean moveBlankRight() {
		if (blankCol != state.length - 1) {
			state[blankRow][blankCol] = state[blankRow][blankCol + 1];
			state[blankRow][blankCol + 1] = 0;
			blankCol++;
			return true;
		}
		return false;
	}

	//Swaps the zero representing the blank with the space above or returns false if the zero has no spaces above it
	public boolean moveBlankUp() {
		if (blankRow != 0) {
			state[blankRow][blankCol] = state[blankRow - 1][blankCol];
			state[blankRow - 1][blankCol] = 0;
			blankRow--;
			return true;
		}
		return false;
	}

	//Swaps the zero representing the blank with the space below or returns false if the zero has no spaces below it
	public boolean moveBlankDown() {
		if (blankRow != state[0].length - 1) {
			state[blankRow][blankCol] = state[blankRow + 1][blankCol];
			state[blankRow + 1][blankCol] = 0;
			blankRow++;
			return true;
		}
		return false;
	}
}
