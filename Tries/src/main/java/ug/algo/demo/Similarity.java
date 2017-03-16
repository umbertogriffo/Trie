package ug.algo.demo;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import ug.algo.trie.Trie;

public class Similarity {
	public static void main(String[] args) {

		// This is a case sensitive trie
		Trie trie = new Trie(true, StandardCharsets.UTF_8);

		// Add words.
		trie.add("Joe");
		trie.add("John");
		trie.add("Johny");
		trie.add("Johnny");
		trie.add("Jane");
		trie.add("Jack");

		System.out.println("Number Of Words: " + trie.getNumberOfWords());
		
		System.out.println("Jane Sim: ");
		for (Map.Entry<String, Integer> entry : trie.getSimilarityMap("Jane", 10).entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		System.out.println(trie.similarity("Jane", 10));
		

	}
}