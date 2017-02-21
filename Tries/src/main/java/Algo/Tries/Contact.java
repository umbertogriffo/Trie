package Algo.Tries;

public class Contact {
	public static void main(String[] args) {
		
		// This is a case sensitive trie
	    Trie trie = new Trie(true);
	    
		trie.add("umberto");
		trie.add("roberto");
		trie.add("Massimiliano");
		trie.add("maurizio");
		
		trie.show();
		
		System.out.println("Number Of Words Starts with 'ma': "+trie.countWordStartsWith("ma"));
		
		System.out.println("Number Of Words: "+trie.getNumberOfWords());
		
	}
}