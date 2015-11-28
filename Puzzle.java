import java.util.ArrayList;

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
		for (int i = 0; i < moves; i++) {
			int[] directions = getDirectionsBlankCanMove();
			int direction = directions[(int) (Math.random() * directions.length)];
			while (direction == lastMove) {
				direction = directions[(int) (Math.random() * directions.length)];
			}
			if (direction == 0) {
				moveBlankLeft();
				lastMove = 1;
			}
			else if (direction == 1) {
				moveBlankRight();
				lastMove = 0;
			}
			else if (direction == 2) {
				moveBlankUp();
				lastMove = 3;
			}
			else {
				moveBlankDown();
				lastMove = 2;
			}
			printState();
		}
	}
	
	public int[] getDirectionsBlankCanMove() {
		ArrayList<Integer> directions = new ArrayList<Integer>(4);
		if (blankRow != 0) {
			directions.add(2);
		}
		
		if (blankRow != puzzleState.length - 1) {
			directions.add(3);
		}
		
		if (blankCol != 0) {
			directions.add(0);
		}
		
		if (blankCol != puzzleState[0].length - 1) {
			directions.add(1);
		}
		
		int[] intDirections = new int[directions.size()];
		for (int i = 0; i < directions.size(); i++) {
			intDirections[i] = directions.get(i);
		}
		return intDirections;
	}
	
	public void moveBlankLeft() {
		puzzleState[blankRow][blankCol] = puzzleState[blankRow][blankCol - 1];
		puzzleState[blankRow][blankCol - 1] = 0;
		blankCol--;
	}
	
	public void moveBlankRight() {
		puzzleState[blankRow][blankCol] = puzzleState[blankRow][blankCol + 1];
		puzzleState[blankRow][blankCol + 1] = 0;
		blankCol++;
	}
	
	public void moveBlankUp() {
		puzzleState[blankRow][blankCol] = puzzleState[blankRow - 1][blankCol];
		puzzleState[blankRow - 1][blankCol] = 0;
		blankRow--;
	}
	
	public void moveBlankDown() {
		puzzleState[blankRow][blankCol] = puzzleState[blankRow + 1][blankCol];
		puzzleState[blankRow + 1][blankCol] = 0;
		blankRow++;
	}
	
	public String printState() {
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
		System.out.println(currentState);
		return currentState;
	}
}
