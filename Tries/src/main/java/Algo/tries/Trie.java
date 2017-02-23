package Algo.tries;

import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Trie(https://en.wikipedia.org/wiki/Trie) is an efficient information
 * retrieval data structure that we can use to search a word in O(M) time, where
 * M is maximum string length. However the penalty is on trie storage
 * requirements.
 * 
 * @author Umberto
 *
 */
public class Trie {
	// Trie accepts only letters
	private final String REGEX_ONLY_LETTERS = "[^a-zA-Z]+";
	// Dummy node
	private Node root;
	// Current number of unique words in trie
	private int numOfwords;
	// If this is a case sensitive trie
	private boolean caseSensitive;

	/**
	 * Constructor.
	 * 
	 * @param caseSensitive
	 *            set if this is a case sensitive trie
	 */
	public Trie(boolean caseSensitive) {
		root = new Node();
		setNumberOfWords(0);
		setCaseSensitive(caseSensitive);
	}

	/**
	 * Inserts a word into the trie.
	 * 
	 * @param word
	 */
	public void add(String word) {
		word = word.trim().replaceAll(REGEX_ONLY_LETTERS, "");
		word = this.caseSensitive ? word : word.toLowerCase();
		Map<Character, Node> children = root.children;

		Node currentParent;
		currentParent = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node node;
			if (children.containsKey(c)) {
				node = children.get(c);
			} else {
				node = new Node(c);
				node.setParent(currentParent);
				children.put(c, node);
			}

			children = node.children;
			currentParent = node;

			// set leaf node
			if (i == word.length() - 1) {
				node.setLeaf(true);
				this.numOfwords++;
			}
			// how many words starting with prefix
			node.setCount(node.getCount() + 1);
		}
	}

	/**
	 * Search a word in the trie.
	 * 
	 * @param word
	 * @return the last word's node
	 */
	public Node searchNode(String word) {
		word = this.caseSensitive ? word : word.toLowerCase();
		Map<Character, Node> children = root.children;
		Node node = null;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (children.containsKey(c)) {
				node = children.get(c);
				children = node.children;
			} else {
				return null;
			}
		}
		return node;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 * 
	 * @param prefix
	 * @return true|false
	 */
	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null)
			return false;
		else
			return true;
	}

	/**
	 * Returns if the word is in the trie.
	 * 
	 * @param word
	 * @return true|false
	 */
	public boolean search(String word) {
		Node t = searchNode(word);
		if (t != null && t.isLeaf())
			return true;
		else
			return false;
	}

	/**
	 * Return how many words starting with prefix.
	 * 
	 * @param prefix
	 * @return how many words starting with prefix
	 */
	public int countWordStartsWith(String prefix) {

		if (!startsWith(prefix)) {
			return 0;
		}

		return (searchNode(prefix).getCount());

	}

	/**
	 * Set to unvisited all the Tries's node.
	 * 
	 * @param node
	 */
	public void initFalse(Node node) {
		node.setVisited(false);
		for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
			initFalse(entry.getValue());
		}
	}

	/**
	 * Show The Trie.
	 */
	public void show() {

		if (this.root != null) {
			this.dfs(this.root);
			this.initFalse(this.root);
		}

	}

	/**
	 * Recursive Depth-first search (DFS).
	 * 
	 * @param node
	 */
	public void dfs(Node node) {
		node.setVisited(true);
		for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
			if (entry.getValue().isVisited() == false) {
				System.out.print("(" + entry.getValue().getC() + ":" + entry.getValue().getCount() + ":"
						+ entry.getValue().getParent().getC() + ")->");
				if (entry.getValue().isLeaf()) {
					System.out.println("*");
				}
				dfs(entry.getValue());
			}
		}
	}

	/**
	 * Iterative Depth-first search (DFS) using stack.
	 * 
	 * @param node
	 * @return
	 */
	public void dfsIterative(Node node) {

		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		node.setVisited(true);
		while (!stack.isEmpty()) {
			Node element = stack.pop();
			System.out.print(element.getC() + "\t");
			if (element.isLeaf()) {
				System.out.println("*");
			}
			for (Map.Entry<Character, Node> entry : element.children.entrySet()) {
				Node n = entry.getValue();
				if (n != null && !n.isVisited()) {
					stack.add(n);
					n.setVisited(true);
				}
			}
		}
	}

	/**
	 * Return words starting with prefix.
	 * 
	 * @param prefix
	 * @return a Stream containing words starting with prefix
	 */
	public Stream<String> getWordStartsWith(String prefix) {
		
		if (!startsWith(prefix)) {
			return Stream.empty();
		}
		
		Stream<Node> leafNodes = getLeafNodes(searchNode(prefix));
		
		return leafNodes.map(node -> {
			Node currentParent = node.getParent();
			StringBuilder wordBuilder = new StringBuilder();			
			while (currentParent != null) {
				if(currentParent.getParent()!=null){
					wordBuilder.append(currentParent.getC());
				}				
				currentParent = currentParent.getParent();
			}
			return wordBuilder.reverse().append(node.getC()).toString();
		}); 

	}

	/**
	 * Return a List containing the Leaf Nodes starting from a node using
	 * Recursive Depth-first search (DFS).
	 * 
	 * @param node
	 * @return a Stream containing the Leaf Nodes
	 */
	public Stream<Node> getLeafNodes(Node node) {
		//List<Node> leafNodes = new LinkedList<Node>();
		node.setVisited(true);
		/*for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
			if (entry.getValue().isVisited() == false) {
//				System.out.print("(" + entry.getValue().getC() + ":" + entry.getValue().getCount() + ":"
//						+ entry.getValue().getParent().getC() + ")->");
				if (entry.getValue().isLeaf()) {
					leafNodes.add(entry.getValue());
					//System.out.println("*");
				}
				leafNodes.addAll(getLeafNodes(entry.getValue()).collect(Collectors.toList()));
			}
		}*/
		return node.children.entrySet().stream().filter(entry->!entry.getValue().isVisited())
		.flatMap(entry->{
			Stream<Node> leafNodeStr = getLeafNodes(entry.getValue());
			if (entry.getValue().isLeaf()) {
				return Stream.concat(Stream.of(entry.getValue()), leafNodeStr);
			}
			else{
				return leafNodeStr;
			}
		});
		//return leafNodes.stream();
	}

	public int getNumberOfWords() {
		return numOfwords;
	}

	private void setNumberOfWords(int words) {
		this.numOfwords = words;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	private void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

}
