
public class Puzzle {
	int[][] puzzleState;
	String goalStateStr;
	int blankRow;
	int blankCol;
	int lastMove = -1;

	public Puzzle(int size) {
		puzzleState = new int[size][size];
	}

	public void initializePuzzle() {
		int currentVal = 0;
		for (int row = 0; row < puzzleState.length; row++) {
			for (int col = 0; col < puzzleState[0].length; col++) {
				puzzleState[row][col] = currentVal;
				currentVal++;
			}
		}
		blankRow = 0;
		blankCol = 0;
		this.goalStateStr = getGoalState();
	}

	public void initializePuzzle(int[][] state) {
		puzzleState = state;
		for (int row = 0; row < puzzleState.length; row++) {
			for (int col = 0; col < puzzleState[0].length; col++) {
				if (puzzleState[row][col] == 0) {
					blankRow = row;
					blankCol = col;
					break;
				}
			}
		}
		this.goalStateStr = getGoalState();
	}

	public void randomizePuzzle(int moves) {
		int movesDone = 0;
		boolean moved;
		while (movesDone < moves) {
			int direction = (int)(Math.random() * 4);
			while (direction == lastMove) {
				direction = (int) (Math.random() * 4);
			}
			if (direction == 0) {
				moved = moveBlankLeft();
				if (moved) lastMove = 1;
			}
			else if (direction == 1) {
				moved = moveBlankRight();
				if (moved) lastMove = 0;
			}
			else if (direction == 2) {
				moved = moveBlankUp();
				if (moved) lastMove = 3;
			}
			else {
				moved = moveBlankDown();
				if (moved) lastMove = 2;
			}
			if (moved) {
				movesDone++;
			}
		}
		System.out.println("Randomized state is:");
		getState(true);
	}

	public boolean moveBlankLeft() {
		if (blankCol != 0) {
			puzzleState[blankRow][blankCol] = puzzleState[blankRow][blankCol - 1];
			puzzleState[blankRow][blankCol - 1] = 0;
			blankCol--;
			return true;
		}
		return false;
	}

	public boolean moveBlankRight() {
		if (blankCol != puzzleState.length - 1) {
			puzzleState[blankRow][blankCol] = puzzleState[blankRow][blankCol + 1];
			puzzleState[blankRow][blankCol + 1] = 0;
			blankCol++;
			return true;
		}
		return false;
	}

	public boolean moveBlankUp() {
		if (blankRow != 0) {
			puzzleState[blankRow][blankCol] = puzzleState[blankRow - 1][blankCol];
			puzzleState[blankRow - 1][blankCol] = 0;
			blankRow--;
			return true;
		}
		return false;
	}

	public boolean moveBlankDown() {
		if (blankRow != puzzleState[0].length - 1) {
			puzzleState[blankRow][blankCol] = puzzleState[blankRow + 1][blankCol];
			puzzleState[blankRow + 1][blankCol] = 0;
			blankRow++;
			return true;
		}
		return false;
	}

	public int[][] getStateArr() {
		int[][] arrCopy = new int[puzzleState.length][puzzleState[0].length];
		for (int i = 0; i < puzzleState.length; i++) {
			for (int j = 0; j < puzzleState.length; j++) {
				arrCopy[i][j] = puzzleState[i][j];
			}
		}
		return arrCopy;
	}
	
	public String getState(boolean print) {
		String currentState = "";
		for (int i = 0; i < puzzleState.length; i++) {
			for (int j = 0; j < puzzleState.length; j++) {
				currentState = currentState + puzzleState[i][j];
				if (j != puzzleState.length - 1) {
					currentState = currentState + " ";
				}
			}
			currentState = currentState + "\n";
		}
		if (print) {
			System.out.println(currentState);
		}
		return currentState;
	}
	
	private String getGoalState() {
		String goalState = "";
		for (int i = 0; i < puzzleState.length; i++) {
			for (int j = 0; j < puzzleState.length; j++) {
				goalState = goalState + ((i*puzzleState.length) + j);
				if (j != puzzleState.length - 1) {
					goalState = goalState + " ";
				}
			}
			goalState = goalState + "\n";
		}
		return goalState;
	}
}
