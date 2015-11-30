
public class Puzzle {
	int[][] puzzleState;
	static int[][] goalState = new int[][] {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
	int blankRow;
	int blankCol;
	int lastMove = -1;

	public Puzzle(int size) {
		puzzleState = new int[size][size];
	}

	public void initializePuzzle() {
		for (int row = 0; row < puzzleState.length; row++) {
			for (int col = 0; col < puzzleState.length; col++) {
				puzzleState[row][col] = (row*3) + col;
			}
		}
		blankRow = 0;
		blankCol = 0;
	}

	public void initializePuzzle(int[][] state) {
		puzzleState = state;
		for (int row = 0; row < puzzleState.length; row++) {
			for (int col = 0; col < puzzleState.length; col++) {
				if (puzzleState[row][col] == 0) {
					blankRow = row;
					blankCol = col;
				}
			}
		}
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
				lastMove = 1;
			}
			else if (direction == 1) {
				moved = moveBlankRight();
				lastMove = 0;
			}
			else if (direction == 2) {
				moved = moveBlankUp();
				lastMove = 3;
			}
			else {
				moved = moveBlankDown();
				lastMove = 2;
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

	public String getState(boolean print) {
		String currentState = "";
		for (int i = 0; i < puzzleState.length; i++) {
			for (int j = 0; j < puzzleState.length; j++) {
				currentState = currentState + puzzleState[i][j];
				if (j != 2) {
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
	
	public String getGoalState() {
		String goalState = "";
		for (int row = 0; row < puzzleState.length; row++) {
			for (int col = 0; col < puzzleState.length; col++) {
				goalState = goalState + ((row*3) + col);
				if (col != 2) {
					goalState = goalState + " ";
				}
			}
			goalState = goalState + "\n";
		}
		return goalState;
	}
}
