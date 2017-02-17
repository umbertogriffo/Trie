## A Simple Trie implementation in Java
* Author: Umberto Griffo
* Twitter: @UmbertoGriffo

Trie is an efficient information retrieval data structure. Using trie, search complexities can be brought to optimal limit (key length). If we store keys in binary search tree, a well balanced BST will need time proportional to M * log N, where M is maximum string length and N is number of keys in tree. Using trie, we can search the key in O(M) time. However the penalty is on trie storage requirements.
Every node of trie consists of multiple branches. Each branch represents a possible character of keys. We need to mark the last node of every key as leaf node.

A trie for keys "A","to", "tea", "ted", "ten", "i", "in", and "inn"
<p align="center">
  <img src="https://github.com/umbertogriffo/Trie/blob/master/250px-Trie_example.svg.png"/>
</p>

###References
- https://en.wikipedia.org/wiki/Trie
- http://www.geeksforgeeks.org/trie-insert-and-search/
