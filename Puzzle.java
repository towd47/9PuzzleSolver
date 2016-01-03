/*
 * The Puzzle class stores the puzzle in the form of a 2D int array
 * It contains methods to move the puzzle from one state to the next
 * It also has functionality to randomize the puzzle and print the puzzle to the console
*/

public class Puzzle {
	Node node;
	private int[][] goalState;
	
	//Constructor
	public Puzzle(int size) {
		node = new Node(size);
		goalState = getGoalStateArr();
	}
	public Puzzle(Node node) {
		this.node = node;
		goalState = getGoalStateArr();
	}

	public static void showSolution(Node node) {

		// Creates solution string and prints solution to console
		String solution = "";
		int movesToSolve = 0;

		while (node.previousNode != null) {
			solution = node.toString() + "\n" + solution;
			node = node.previousNode;
			movesToSolve++;
		}
		solution = node.toString() + "\n" + solution;
		System.out.print(solution);
		System.out.println("Took " + movesToSolve + " moves to solve puzzle.");
	}
	
	public boolean isSolved() {
		for (int row = 0; row < node.state.length; row++) {
			for (int col = 0; col < node.state[0].length; col++) {
				if(node.state[row][col] != goalState[row][col]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void randomizePuzzle(int moves) {
		int lastMove = -1;
		int movesDone = 0;
		boolean moved;
		while (movesDone < moves) {
			int direction = (int)(Math.random() * 4);
			while (direction == lastMove) {
				direction = (int) (Math.random() * 4);
			}
			if (direction == 0) {
				moved = node.moveBlankLeft();
				if (moved) lastMove = 1;
			}
			else if (direction == 1) {
				moved = node.moveBlankRight();
				if (moved) lastMove = 0;
			}
			else if (direction == 2) {
				moved = node.moveBlankUp();
				if (moved) lastMove = 3;
			}
			else {
				moved = node.moveBlankDown();
				if (moved) lastMove = 2;
			}
			if (moved) {
				movesDone++;
			}
			//System.out.println(node.toString);
			//TO SEE EACH STEP OF THE RANDOMIZER FOR TESTING
			//UNCOMMENT THE LINE ABOVE
		}
		System.out.println("Randomized state is:");
		System.out.println(node.toString());
	}
	
	private int[][] getGoalStateArr() {
		int[][] goalState = new int[node.state.length][node.state[0].length];
		for (int i = 0; i < node.state.length; i++) {
			for (int j = 0; j < node.state.length; j++) {
				goalState[i][j] = (i*node.state.length) + j;
			}
		}
		return goalState;
	}
}
