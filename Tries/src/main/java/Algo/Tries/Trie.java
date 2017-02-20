package Algo.Tries;

import java.util.Map;
import java.util.Stack;

public class Trie {

	private final String REGEX_ONLY_LETTERS = "[^a-zA-Z]+";
	
	private Node root;
	
	// current number of unique words in trie
	private int words;
	
	// if this is a case sensitive trie
	private boolean caseSensitive;
	
	public Trie(boolean caseSensitive) {
		root = new Node();
		this.words = 0;
		this.caseSensitive = caseSensitive;
	}

	/**
	 * Inserts a word into the trie.
	 * @param word
	 */
	public void insert(String word) {
		word = word.trim().replaceAll(REGEX_ONLY_LETTERS, "");
		word = this.caseSensitive ? word : word.toLowerCase();
		Map<Character, Node> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node node;
			if (children.containsKey(c)) {
				node = children.get(c);
			} else {
				node = new Node(c);
				children.put(c, node);
			}

			children = node.children;

			// set leaf node
			if (i == word.length() - 1){
				node.setLeaf(true);
				this.words++;
			}
			// how many words starting with prefix
			node.setCount(node.getCount() + 1);
		}
	}

	/**
	 * Search a word in the trie.
	 * @param word
	 * @return
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
	 *  Returns if there is any word in the trie
	 *  that starts with the given prefix.
	 * @param prefix
	 * @return
	 */
	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null)
			return false;
		else
			return true;
	}

	/**
	 *  Returns if the word is in the trie.
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		Node t = searchNode(word);
		if (t != null && t.isLeaf())
			return true;
		else
			return false;
	}

	/**
	 * Return how many words starting with prefix
	 * @param prefix
	 * @return
	 */
	public int countWordStartsWith(String prefix) {

		if (!startsWith(prefix)) {
			return 0;
		}

		return (searchNode(prefix).getCount());
	
	}

	/**
	 * Set to unvisited all the Tries's node
	 * @param node
	 */
	public void initFalse(Node node) {
		node.setVisited(false);
		for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
			initFalse(entry.getValue());
		}
	}
	
	/**
	 * Show The Trie
	 */
	public void show(){
		
		if(this.root!=null){
			this.dfs(this.root);
			this.initFalse(this.root);
		}
	
	}
	
	/**
	 * Recursive Depth-first search (DFS)
	 * @param node
	 */
	public void dfs(Node node) {
		node.setVisited(true);
		for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
			if (entry.getValue().isVisited() == false) {
				System.out.print("("+entry.getValue().getC() + ":" +entry.getValue().getCount() +")\t->\t");
				if (entry.getValue().isLeaf()) {
					System.out.println("*");
				}
				dfs(entry.getValue());
			}
		}
	}

	/**
	 * Iterative Depth-first search (DFS) using stack
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

	public int getWords() {
		return words;
	}

	public void setWords(int words) {
		this.words = words;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

}
