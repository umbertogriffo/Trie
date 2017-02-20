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
- find partial, where *partial* is a string denoting a partial name to search the application for. It must count the number of contacts starting with *partial* and print the count on a new line.

Given *n* sequential *add* and *find* operations, perform each operation in order:

``` 
9
add umberto
add roberto
add emanuele
add tushare
add flavio
add massimiliano
add maurizio
find ma
find tup
```

For each find partial operation, print the number of contact names starting with *partial* on a new line:
``` 
2
0
```

Example of Main Java Class:
``` java
public class App {
	public static void main(String[] args) {
		
		File fileName = new File("Input/testCase4");

		Trie trie = new Trie();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			br.readLine();
			for (String line; (line = br.readLine()) != null;) {
				System.out.println(line);
				String[] in = line.split(" ");
				String op = in[0];
				String contact = in[1];

				if (op.equals("add")) {
					trie.insert(contact);
				} else if (op.equals("find")) {
					System.out.println(trie.countWordStartsWith(contact));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
``` 
###References
- [1] https://en.wikipedia.org/wiki/Trie
- [2] https://www.hackerrank.com/challenges/contacts
