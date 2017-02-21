package Algo.Tries;

import java.util.List;

public class Contact {
	public static void main(String[] args) {
		
		// This is a case sensitive trie
	    Trie trie = new Trie(true);
	    
		trie.add("Joe");
		trie.add("John");
		trie.add("Johny");
		trie.add("Johnny");		
		trie.add("Jane");
		trie.add("jack");
		
		System.out.println("Number Of Words: "+trie.getNumberOfWords());
		
		trie.show();
		
		System.out.println("Number Of Words Starts with 'Jo': "+trie.countWordStartsWith("Jo"));
		System.out.println("Number Of Words Starts with 'ja': "+trie.countWordStartsWith("ja"));
		
		List<String> words = trie.getWordStartsWith("Jo");
		for(String word:words){
			System.out.println(word);
		}	
	}
}