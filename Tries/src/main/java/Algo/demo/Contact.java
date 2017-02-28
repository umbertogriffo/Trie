package Algo.demo;

import java.util.stream.Stream;

import Algo.tries.Trie;

public class Contact {
	public static void main(String[] args) {
		
		// This is Sa case sensitive trie
	    Trie trie = new Trie(true);
	    
		trie.add("Joe");
		trie.add("John");
		trie.add("Johny");
		trie.add("Johnny");		
		trie.add("Jane");
		trie.add("Jack");
		
		System.out.println("Number Of Words: "+trie.getNumberOfWords());
		
		trie.show();
		
		System.out.println("Number Of Words Starts with 'Jo': "+trie.countWordStartsWith("John"));
		System.out.println("Number Of Words Starts with 'Ja': "+trie.countWordStartsWith("Ja"));
		
		Stream<String> words = trie.getWordStartsWith("Jo");
		words.forEach(System.out::println);
		Stream<String> words2 = trie.getWordStartsWith("a");
		words2.forEach(System.out::println);
	
		trie.show();
	}
}