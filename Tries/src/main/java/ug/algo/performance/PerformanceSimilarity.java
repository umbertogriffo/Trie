package ug.algo.performance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

import ug.algo.trie.Trie;

public class PerformanceSimilarity {
	public static void main(String[] args) {

		String word = "china";
		int MaxDistance = 3;

		File fileName = new File("Input/text8.txt");

		/**
		 * GENERATE TRIE
		 */
		// Calculate Elapsed / Execute Time
		long startTime = System.currentTimeMillis();
		// this is a case sensitive trie
		Trie trie = new Trie(true, StandardCharsets.UTF_8);
		System.out.println("Loading words into Trie...");
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			for (String line; (line = br.readLine()) != null;) {
				// System.out.println(line);
				String[] words = line.split(" ");
				System.out.println("File's containing " + words.length + " words");
				for (int i = 0; i < words.length; i++) {
					trie.add(words[i]);
				}
			}

			System.out.println("Number Of Words: " + trie.getNumberOfWords());

			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("Elapsed / Execute Time");
			System.out.println("Elapsed Time in milliseconds: " + elapsedTime);
			System.out.println("Elapsed Time in seconds: " + (elapsedTime / 1000) % 60);
			System.out.println("Elapsed Time in minutes: " + ((elapsedTime / (1000 * 60)) % 60));
			System.out.println("Elapsed Time in hours: " + ((elapsedTime / (1000 * 60 * 60)) % 24));

			/**
			 * Count Words Starts With
			 */
			System.out.println("");
			System.out.println("Count Words Starts With " + word);
			// Calculate Elapsed / Execute Time
			long startTimeGetCountWordStartsWith = System.currentTimeMillis();
			System.out.println("Number Of Words Starts with " + word + " " + trie.countWordStartsWith(word));

			long stopTimeGetCountWordStartsWith = System.currentTimeMillis();
			long elapsedTimeGetCountWordStartsWith = stopTimeGetCountWordStartsWith - startTimeGetCountWordStartsWith;
			System.out.println("Elapsed / Execute Time");
			System.out.println("Elapsed Time in milliseconds: " + elapsedTimeGetCountWordStartsWith);
			System.out.println("Elapsed Time in seconds: " + (elapsedTimeGetCountWordStartsWith / 1000) % 60);
			System.out.println("Elapsed Time in minutes: " + ((elapsedTimeGetCountWordStartsWith / (1000 * 60)) % 60));
			System.out
					.println("Elapsed Time in hours: " + ((elapsedTimeGetCountWordStartsWith / (1000 * 60 * 60)) % 24));

			/**
			 * Get Words Starts With
			 */
			System.out.println("");
			System.out.println("Get Words Starts With " + word);
			// Calculate Elapsed / Execute Time
			long startTimeGetWordStartsWith = System.currentTimeMillis();
			trie.getWordStartsWith(word).collect(Collectors.toList());
			long stopTimeGetWordStartsWith = System.currentTimeMillis();
			long elapsedTimeGetWordStartsWith = stopTimeGetWordStartsWith - startTimeGetWordStartsWith;
			System.out.println("Elapsed / Execute Time");
			System.out.println("Elapsed Time in milliseconds: " + elapsedTimeGetWordStartsWith);
			System.out.println("Elapsed Time in seconds: " + (elapsedTimeGetWordStartsWith / 1000) % 60);
			System.out.println("Elapsed Time in minutes: " + ((elapsedTimeGetWordStartsWith / (1000 * 60)) % 60));
			System.out.println("Elapsed Time in hours: " + ((elapsedTimeGetWordStartsWith / (1000 * 60 * 60)) % 24));

			/**
			 * Get Words Starts With (Java7)
			 */
			System.out.println("");
			System.out.println("(Java7) Get Words Starts With " + word);
			// Calculate Elapsed / Execute Time
			long startTimeGetWordStartsWithJava7 = System.currentTimeMillis();
			trie.getWordStartsWithJava7(word);
			long stopTimeGetWordStartsWithJava7 = System.currentTimeMillis();
			long elapsedTimeGetWordStartsWithJava7 = stopTimeGetWordStartsWithJava7 - startTimeGetWordStartsWithJava7;
			System.out.println("Elapsed / Execute Time");
			System.out.println("Elapsed Time in milliseconds: " + elapsedTimeGetWordStartsWithJava7);
			System.out.println("Elapsed Time in seconds: " + (elapsedTimeGetWordStartsWithJava7 / 1000) % 60);
			System.out.println("Elapsed Time in minutes: " + ((elapsedTimeGetWordStartsWithJava7 / (1000 * 60)) % 60));
			System.out
					.println("Elapsed Time in hours: " + ((elapsedTimeGetWordStartsWithJava7 / (1000 * 60 * 60)) % 24));

			/**
			 * Similarity
			 */
			System.out.println("");
			System.out.println("Similarity (" + MaxDistance + ") " + word);
			// Calculate Elapsed / Execute Time
			long startTimeSimilarity = System.currentTimeMillis();
			Map<String, Integer> res = trie.getSimilarityMap(word, 2);
			System.out.println("Number of words similar to word " + word + ": " + res.size());
			/*
			 * for (Map.Entry<String, Integer> entry :
			 * trie.getSimilarityMap("china", 3).entrySet()) {
			 * System.out.println(entry.getKey() + " - " + entry.getValue()); }
			 */
			long stopTimeSimilarity = System.currentTimeMillis();
			long elapsedTimeSimilarity = stopTimeSimilarity - startTimeSimilarity;
			System.out.println("Elapsed / Execute Time");
			System.out.println("Elapsed Time in milliseconds: " + elapsedTimeSimilarity);
			System.out.println("Elapsed Time in seconds: " + (elapsedTimeSimilarity / 1000) % 60);
			System.out.println("Elapsed Time in minutes: " + ((elapsedTimeSimilarity / (1000 * 60)) % 60));
			System.out.println("Elapsed Time in hours: " + ((elapsedTimeSimilarity / (1000 * 60 * 60)) % 24));

			/**
			 * Remove
			 */
			System.out.println("");
			System.out.println("Remove " + word);
			// Calculate Elapsed / Execute Time
			long startTimeRemove = System.currentTimeMillis();
			trie.remove(word);
			System.out.println("Number Of Words: " + trie.getNumberOfWords());
			long stopTimeRemove = System.currentTimeMillis();
			long elapsedTimeRemove = stopTimeRemove - startTimeRemove;
			System.out.println("Elapsed / Execute Time");
			System.out.println("Elapsed Time in milliseconds: " + elapsedTimeRemove);
			System.out.println("Elapsed Time in seconds: " + (elapsedTimeRemove / 1000) % 60);
			System.out.println("Elapsed Time in minutes: " + ((elapsedTimeRemove / (1000 * 60)) % 60));
			System.out.println("Elapsed Time in hours: " + ((elapsedTimeRemove / (1000 * 60 * 60)) % 24));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
