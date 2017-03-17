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

Retrieving data stored in Trie data structure is very fast, so it is most suited for application where retrieval are more frequently performed like Phone directory where contact searching operation is used frequently [1-3].

### Searching Contact from Mobile Contact list OR Phone Directory

Auto suggestion of words while searching for anything in dictionary is very common [2-3].
If we search for word "tiny", then it auto suggest words starting with same characters like "tine", "tin", "tinny" etc.

### String Similarity 

Trie can be used to Fast and Easy calculate Levenshtein distance [4-5].

## Example of usage

With this implementation you can perform the follows operations:

- **Add** a word.
- **Remove** a word.
- **Check** if there is any word in the trie that starts with the given **prefix**.
- **Check** if a word is in the trie.
- **Count words starts with a partial name** to search the application for.
- **Get words starts with a partial name** to search the application for.
- **Show** the Trie
- Calculate **string similarity** using Levenshtein distance.

``` java

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class Demo {
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
		// Return true if there is any word in the trie that starts with the given prefix.
		System.out.println(trie.startsWith("Ja",true));
		// Remove a word
		trie.remove("Johnny");

		// Count words starts with a partial name to search the application for
		System.out.println("Number Of Words Starts with 'John': " + trie.countWordStartsWith("John"));
		System.out.println("Number Of Words Starts with 'Ja': " + trie.countWordStartsWith("Ja"));
		// Get words starts with a partial name to search the application for
		Stream<String> words = trie.getWordStartsWith("Jo");
		words.forEach(System.out::println);
		
		// String Similarity using Levenshtein distance		
		// Get words that are less than the given maximum distance from the target word
		for (Map.Entry<String, Integer> entry : trie.getSimilarityMap("Jane", 1).entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		// Get word that is less than the given maximum distance from the target word
		System.out.println(trie.similarity("Jane", 1));
	}
}
``` 
## Performance

The tests have been carried out on a Laptop (Intel(R) Core(TM) i7-4510U CPU @ 2.00GHz, 8GB RAM).
I've added **483.805 distinct words** into Trie and I've performed the following tests using the word "rap":

|Operation|Time (millisecond)|Result|
|----|----|----|
|Loading words into Trie|970|483.805|
|Count words starts with prefix 'rap'|0,03|147|
|Get words starts with prefix 'rap'|1,69| a List containing 147 words|
|Similarity (Maximum Distance 1) from word rap|22,98| a Map containing 48 similar words|
|Remove word rap|0,04| |

## Complexity (Average)

|Access|Search|Insertion|Deletion|String Similarity|
|----|----|----|----|----|
|O(k)|O(k)|O(k)|O(k)|O(k*n)|

where **k** is maximum string length and **n** is number of nodes in the trie

## References
- [1] Trie https://en.wikipedia.org/wiki/Trie
- [2] Hackerrank challenge contacts https://www.hackerrank.com/challenges/contacts
- [3] What is a trie? What is its importance and how it is implemented? https://www.quora.com/What-is-a-trie-What-is-its-importance-and-how-it-is-implemented
- [4] Fast and Easy Levenshtein distance using a Trie http://stevehanov.ca/blog/index.php?id=114
- [5] Levenshtein distance https://en.wikipedia.org/wiki/Levenshtein_distance
