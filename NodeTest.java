import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testConstructorsAndGetState() {
		Node node1 = new Node(2);
		Node node2 = new Node(node1.state, node1);
		assertEquals("node1 should give the correct string when getState is used on it", node1.toString(), "0 1\n2 3\n");
		assertEquals("node2.previous node should be node 1", node2.previousNode, node1);
	}
	
	@Test
	public void testMoveBlankLeft() {
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		Node node = new Node(testState);
		assertTrue("moveBlankLeft should return true if the blank moved left", node.moveBlankLeft());
		assertEquals("The 3 and 0 should have swapped in the puzzle state", node.toString(), "1 4 2\n0 3 5\n6 7 8\n");
		assertFalse("moveBlankLeft should return false if the blank cant move left", node.moveBlankLeft());
	}

	@Test
	public void testMoveBlankRight() {
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		Node node = new Node(testState);
		assertTrue("moveBlankRight should return true if the blank moved right", node.moveBlankRight());
		assertEquals("The 3 and 0 should have swapped in the puzzle state", node.toString(), "1 4 2\n3 5 0\n6 7 8\n");
		assertFalse("moveBlankRight should return false if the blank cant move right", node.moveBlankRight());
	}

	@Test
	public void testMoveBlankUp() {
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		Node node = new Node(testState);
		assertTrue("moveBlankUp should return true if the blank moved up", node.moveBlankUp());
		assertEquals("The 3 and 0 should have swapped in the puzzle state", node.toString(), "1 0 2\n3 4 5\n6 7 8\n");
		assertFalse("moveBlankUp should return false if the blank cant move up", node.moveBlankUp());
	}

	@Test
	public void testMoveBlankDown() {
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		Node node = new Node(testState);
		assertTrue("moveBlankDown should return true if the blank moved down", node.moveBlankDown());
		assertEquals("The 3 and 0 should have swapped in the puzzle state", node.toString(), "1 4 2\n3 7 5\n6 0 8\n");
		assertFalse("moveBlankDown should return false if the blank cant move down", node.moveBlankDown());
	}
	
	@Test
	public void testGetStateArr() {
		int[][] testState = new int[][] {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
		Node node = new Node(testState);
		int[][] comparer = node.getStateArr();
		for (int i = 0; i < node.state.length; i++) {
			for (int j = 0; j < node.state.length; j++) {
				assertEquals("getStateArr should return the same array as the array the puzzle was initialized with", 
						comparer[i][j], node.state[i][j]);
			}
		}
	}
}
