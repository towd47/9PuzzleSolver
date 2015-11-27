
public class PuzzleRunner {
	
	public static void main(String[] args) {
		Puzzle puzz = new Puzzle(3);
		puzz.initializePuzzle();
		puzz.printState();
		puzz.randomizePuzzle(7);
	}
}
