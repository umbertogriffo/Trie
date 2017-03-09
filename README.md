# A Trie implementation in Java
* Author: Umberto Griffo
* Twitter: @UmbertoGriffo

**Trie**[1] is an ordered tree data structure that uses strings as keys. It's an efficient information retrieval data structure that we can use to search a word in **O(M)** time, where **M** is maximum string length. However the penalty is on trie storage requirements.
A common application of a **trie** is storing a **predictive text** or **autocomplete dictionary**, such as found on a mobile telephone.
Such applications take advantage of a trie's ability to quickly search for, insert, and delete entries.

The following picture shows a trie with the keys "Joe", "John", "Johnny", "Johnny", "Jane", and "Jack"
<p align="center">
  <img src="https://github.com/umbertogriffo/Trie/blob/master/Trie_example.png" height="330" width="330" />
</p>

## Use Case

### Dictionary Suggestions OR Autocomplete dictionary

Retrieving data stored in Trie data structure is very fast, so it is most suited for application where retrieval are more frequently performed like Phone directory where contact searching operation is used frequently.

### Searching Contact from Mobile Contact list OR Phone Directory [2-3]

Auto suggestion of words while searching for anything in dictionary is very common.
If we search for word "tiny", then it auto suggest words starting with same characters like "tine", "tin", "tinny" etc.

## Example of usage

We can perform four types of operations:

- add name, where *name* is a string denoting a contact name. This must store *name* as a new contact in the application.
- count words starts with a partial name to search the application for.
- get words starts with a partial name to search the application for.
- show the Trie

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
		System.out.println("Number Of Words: " + trie.getNumberOfWords());

		trie.show();

		trie.remove("Johnny");

		System.out.println("Number Of Words Starts with 'John': " + trie.countWordStartsWith("John"));
		System.out.println("Number Of Words Starts with 'Ja': " + trie.countWordStartsWith("Ja"));

		Stream<String> words = trie.getWordStartsWith("Jo");
		words.forEach(System.out::println);
	}
}
``` 
## Complexity (Average)

|Access|Search|Insertion|Deletion|
|----|----|----|----|
|O(k)|O(k)|O(k)|O(k)|

where **k** is maximum string length

##References
- [1] https://en.wikipedia.org/wiki/Trie
- [2] https://www.hackerrank.com/challenges/contacts
- [3] https://www.quora.com/What-is-a-trie-What-is-its-importance-and-how-it-is-implemented
