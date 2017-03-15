package Algo.tries;

import java.nio.charset.StandardCharsets;

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
		Trie trie = new Trie(false, StandardCharsets.UTF_8);
		trie.add("hack");
		trie.add("hackerrank");
		assertTrue(trie.countWordStartsWith("hac") == 2);
		assertTrue(trie.countWordStartsWith("hak") == 0);
	}

	public void testDuplicate() {
		Trie trie = new Trie(false, StandardCharsets.UTF_8);
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

	public void testRemove1() {
		Trie trie = new Trie(false, StandardCharsets.UTF_8);
		trie.add("s");
		trie.add("ss");
		trie.add("sss");
		trie.add("ssss");
		trie.add("sssss");
		trie.remove("s");
		assertTrue(trie.countWordStartsWith("s") == 4);
		trie.remove("sss");
		assertTrue(trie.countWordStartsWith("sss") == 2);
		trie.remove("ssss");
		assertTrue(trie.countWordStartsWith("sssss") == 1);
		trie.remove("ss");
		assertTrue(trie.countWordStartsWith("ss") == 1);
		trie.remove("sssss");
		assertTrue(trie.countWordStartsWith("sssss") == 0);
		assertTrue(trie.getNumberOfWords() == 0);
	}

	public void testRemove2() {
		Trie trie = new Trie(true, StandardCharsets.UTF_8);
		trie.add("Joe");
		trie.add("John");
		trie.add("Johny");
		trie.add("Johnny");
		trie.add("Jane");
		trie.add("Jack");

		trie.remove("Johnny");
		assertTrue(trie.countWordStartsWith("John") == 2);
		assertTrue(trie.countWordStartsWith("Ja") == 2);
		trie.remove("Jack");
		assertTrue(trie.countWordStartsWith("John") == 2);
		assertTrue(trie.countWordStartsWith("Ja") == 1);
		trie.remove("Joe");
		assertTrue(trie.countWordStartsWith("John") == 2);
		assertTrue(trie.countWordStartsWith("Ja") == 1);
		trie.remove("John");
		assertTrue(trie.countWordStartsWith("John") == 1);
		assertTrue(trie.countWordStartsWith("Ja") == 1);
		trie.remove("Jane");
		assertTrue(trie.countWordStartsWith("John") == 1);
		assertTrue(trie.countWordStartsWith("Ja") == 0);
		trie.remove("Johny");
		assertTrue(trie.countWordStartsWith("John") == 0);
		assertTrue(trie.countWordStartsWith("Ja") == 0);

		assertTrue(trie.getNumberOfWords() == 0);
	}

	public void testRemove3() {
		Trie trie = new Trie(false, StandardCharsets.UTF_8);
		trie.add("s");
		trie.remove("s");
		assertTrue(trie.countWordStartsWith("s") == 0);
		assertTrue(trie.getNumberOfWords() == 0);
	}

	public void testCaseSensitive() {
		Trie trie = new Trie(true, StandardCharsets.UTF_8);
		trie.add("umberto");
		trie.add("roberto");
		trie.add("Massimiliano");
		trie.add("maurizio");
		assertTrue(trie.countWordStartsWith("ma") == 1);
	}

}
