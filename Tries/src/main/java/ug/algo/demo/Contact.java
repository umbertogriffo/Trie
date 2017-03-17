package ug.algo.demo;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import ug.algo.trie.Trie;

public class Contact {
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
		
		trie.show();

		// Return true if the word is in the trie.
		System.out.println(trie.search("Jane",true));
		// Return true if there is any word in the trie that starts with the
		// given prefix.
		System.out.println(trie.startsWith("Ja",true));
		// Remove a word
		trie.remove("Johnny");
		
		System.out.println("Number Of Words: " + trie.getNumberOfWords());

		trie.show();

		// Count words starts with a partial name to search the application for
		System.out.println("Number Of Words Starts with 'John': " + trie.countWordStartsWith("John"));
		System.out.println("Number Of Words Starts with 'Ja': " + trie.countWordStartsWith("Ja"));
		// Get words starts with a partial name to search the application for
		Stream<String> words = trie.getWordStartsWith("Jo");
		words.forEach(System.out::println);
	}
}