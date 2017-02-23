## A Trie implementation in Java
* Author: Umberto Griffo
* Twitter: @UmbertoGriffo

**Trie**[1] is an ordered tree data structure that uses strings as keys. It's an efficient information retrieval data structure that we can use to search a word in **O(M)** time, where **M** is maximum string length. However the penalty is on trie storage requirements.

The following picture shows a trie with the keys "Joe", "John", "Johnny", "Johnny", "Jane", and "Jack"
<p align="center">
  <img src="https://github.com/umbertogriffo/Trie/blob/master/Trie_example.png" height="330" width="330" />
</p>

A common application of a **trie** is storing a **predictive text** or **autocomplete dictionary**, such as found on a mobile telephone. Such applications take advantage of a trie's ability to quickly search for, insert, and delete entries.

For example we can make our own Contacts application[2]. 
The application must perform two types of operations:

- add name, where *name* is a string denoting a contact name. This must store *name* as a new contact in the application.
- count words starts with a partial name to search the application for.

Example of usage:
``` java
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
		
		Stream<String> words = trie.getWordStartsWith("Jo");
		words.forEach(System.out::println);
		Stream<String> words2 = trie.getWordStartsWith("a");
		words2.forEach(System.out::println);

	}
}
``` 

###References
- [1] https://en.wikipedia.org/wiki/Trie
- [2] https://www.hackerrank.com/challenges/contacts
