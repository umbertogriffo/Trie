package Algo.tries;

import Algo.tries.Trie;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testBasic() {
		Trie trie = new Trie(false);
		trie.add("hack");
		trie.add("hackerrank");
		assertTrue(trie.countWordStartsWith("hac") == 2);
		assertTrue(trie.countWordStartsWith("hak") == 0);
	}

	public void testDuplicate() {
		Trie trie = new Trie(false);
		trie.add("s");
		trie.add("ss");
		trie.add("sss");
		trie.add("ssss");
		trie.add("sssss");
		assertTrue(trie.countWordStartsWith("s") == 5);
		assertTrue(trie.countWordStartsWith("ss") == 4);
		assertTrue(trie.countWordStartsWith("sss") == 3);
		assertTrue(trie.countWordStartsWith("ssss") == 2);
		assertTrue(trie.countWordStartsWith("sssss") == 1);
		assertTrue(trie.countWordStartsWith("ssssss") == 0);
	}

	public void testCaseSensitive() {
		Trie trie = new Trie(true);
		trie.add("umberto");
		trie.add("roberto");
		trie.add("Massimiliano");
		trie.add("maurizio");
		assertTrue(trie.countWordStartsWith("ma") == 1);
	}

}
