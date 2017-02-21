## A Simple Trie implementation in Java
* Author: Umberto Griffo
* Twitter: @UmbertoGriffo

**Trie**[1] is an efficient information retrieval data structure that we can use to search a word in **O(M)** time, where **M** is maximum string length. However the penalty is on trie storage requirements.

The following picture shows a trie with the keys "A","to", "tea", "ted", "ten", "i", "in", and "inn"
<p align="center">
  <img src="https://github.com/umbertogriffo/Trie/blob/master/250px-Trie_example.svg.png"/>
</p>

A common application of a **trie** is storing a **predictive text** or **autocomplete dictionary**, such as found on a mobile telephone. Such applications take advantage of a trie's ability to quickly search for, insert, and delete entries.

For example we can make our own Contacts application[2]. 
The application must perform two types of operations:

- add name, where *name* is a string denoting a contact name. This must store *name* as a new contact in the application.
- count words starts with a partial name to search the application for.

Example of use:
``` java
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
``` 
###References
- [1] https://en.wikipedia.org/wiki/Trie
- [2] https://www.hackerrank.com/challenges/contacts
