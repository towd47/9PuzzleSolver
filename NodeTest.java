import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testConstructorsAndGetState() {
		int[][] tester = new int[][] {{0, 1}, {2, 3}};
		Node node1 = new Node(tester);
		Node node2 = new Node(tester, node1);
		assertEquals("node1 should give the correct string when getState is used on it", node1.getState(), "0 1\n2 3\n");
		assertEquals("node2.previous node should be node 1", node2.previousNode, node1);
	}
}
