package ug.algo.performance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

import ug.algo.trie.Trie;

public class PerformanceSimilarityBigger {
	public static void main(String[] args) {

		String word = "rap";
		int MaxDistance = 1;

		File fileName1 = new File("Input/words.txt");
		File fileName2 = new File("Input/words2.txt");
		File fileName3 = new File("Input/words3.txt");

		/**
		 * GENERATE TRIE
		 */

		// this is a case sensitive trie
		Trie trie = new Trie(true, StandardCharsets.UTF_8);
		System.out.println("Loading words into Trie...");
		
		// Calculate Elapsed / Execute Time
		long startTime = System.nanoTime();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName1))) {
			for (String line; (line = br.readLine()) != null;) {
				// System.out.println(line);
				trie.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(fileName2))) {
			for (String line; (line = br.readLine()) != null;) {
				// System.out.println(line);
				trie.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(fileName3))) {
			for (String line; (line = br.readLine()) != null;) {
				// System.out.println(line);
				trie.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Number Of Words inserted: " + trie.getNumberOfWords());
		long stopTime = System.nanoTime();
		double elapsedTime = (stopTime - startTime)/1e6;
		System.out.println("Elapsed / Execute Time");
		System.out.println("Elapsed Time in milliseconds: " + elapsedTime);
		System.out.println("Elapsed Time in seconds: " + (elapsedTime / 1000.0) % 60.0);
		System.out.println("Elapsed Time in minutes: " + ((elapsedTime / (1000.0 * 60.0)) % 60.0));
		System.out.println("Elapsed Time in hours: " + ((elapsedTime / (1000.0 * 60.0 * 60.0)) % 24.0));

		/**
		 * Count Words Starts With
		 */
		System.out.println("");
		System.out.println("Count Words Starts With " + word);
		// Calculate Elapsed / Execute Time
		long startTimeGetCountWordStartsWith = System.nanoTime();
		System.out.println("The Number Of Words Starts With " + word + " is " + trie.countWordStartsWith(word));

		long stopTimeGetCountWordStartsWith = System.nanoTime();
		double elapsedTimeGetCountWordStartsWith = (stopTimeGetCountWordStartsWith - startTimeGetCountWordStartsWith)/1e6;
		System.out.println("Elapsed / Execute Time");
		System.out.println("Elapsed Time in milliseconds: " + elapsedTimeGetCountWordStartsWith);
		System.out.println("Elapsed Time in seconds: " + (elapsedTimeGetCountWordStartsWith / 1000.0) % 60.0);
		System.out.println("Elapsed Time in minutes: " + ((elapsedTimeGetCountWordStartsWith / (1000.0 * 60.0)) % 60.0));
		System.out.println("Elapsed Time in hours: " + ((elapsedTimeGetCountWordStartsWith / (1000.0 * 60.0 * 60.0)) % 24.0));

		/**
		 * Get Words Starts With
		 */
		System.out.println("");
		System.out.println("Get Words Starts With " + word);
		// Calculate Elapsed / Execute Time
		long startTimeGetWordStartsWith = System.nanoTime();
		System.out.println(trie.getWordStartsWith(word).collect(Collectors.toList()).size());
		long stopTimeGetWordStartsWith = System.nanoTime();
		double elapsedTimeGetWordStartsWith = (stopTimeGetWordStartsWith - startTimeGetWordStartsWith)/1e6;;
		System.out.println("Elapsed / Execute Time");
		System.out.println("Elapsed Time in milliseconds: " + elapsedTimeGetWordStartsWith);
		System.out.println("Elapsed Time in seconds: " + (elapsedTimeGetWordStartsWith / 1000.0) % 60.0);
		System.out.println("Elapsed Time in minutes: " + ((elapsedTimeGetWordStartsWith / (1000.0 * 60.0)) % 60.0));
		System.out.println("Elapsed Time in hours: " + ((elapsedTimeGetWordStartsWith / (1000.0 * 60.0 * 60.0)) % 24.0));

		/**
		 * Get Words Starts With (Java7)
		 */
		System.out.println("");
		System.out.println("(Java7) Get Words Starts With " + word);
		// Calculate Elapsed / Execute Time
		long startTimeGetWordStartsWithJava7 = System.nanoTime();
		trie.getWordStartsWithJava7(word);
		long stopTimeGetWordStartsWithJava7 = System.nanoTime();
		double elapsedTimeGetWordStartsWithJava7 = (stopTimeGetWordStartsWithJava7 - startTimeGetWordStartsWithJava7)/1e6;;
		System.out.println("Elapsed / Execute Time");
		System.out.println("Elapsed Time in milliseconds: " + elapsedTimeGetWordStartsWithJava7);
		System.out.println("Elapsed Time in seconds: " + (elapsedTimeGetWordStartsWithJava7 / 1000.0) % 60.0);
		System.out.println("Elapsed Time in minutes: " + ((elapsedTimeGetWordStartsWithJava7 / (1000.0 * 60.0)) % 60.0));
		System.out.println("Elapsed Time in hours: " + ((elapsedTimeGetWordStartsWithJava7 / (1000.0 * 60.0 * 60.0)) % 24.0));

		/**
		 * Similarity
		 */
		System.out.println("");
		System.out.println("Similarity (Maximum Distance " + MaxDistance + ") " + word);
		// Calculate Elapsed / Execute Time
		long startTimeSimilarity = System.nanoTime();
		Map<String, Integer> res = trie.getSimilarityMap(word, MaxDistance);
		System.out.println("Number of words similar to word " + word + ": " + res.size());
		for (Map.Entry<String, Integer> entry : res.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		long stopTimeSimilarity = System.nanoTime();
		double elapsedTimeSimilarity = (stopTimeSimilarity - startTimeSimilarity)/1e6;;
		System.out.println("Elapsed / Execute Time");
		System.out.println("Elapsed Time in milliseconds: " + elapsedTimeSimilarity);
		System.out.println("Elapsed Time in seconds: " + (elapsedTimeSimilarity / 1000.0) % 60.0);
		System.out.println("Elapsed Time in minutes: " + ((elapsedTimeSimilarity / (1000.0 * 60.0)) % 60.0));
		System.out.println("Elapsed Time in hours: " + ((elapsedTimeSimilarity / (1000.0 * 60.0 * 60.0)) % 24.0));

		/**
		 * Remove
		 */
		System.out.println("");
		System.out.println("Remove " + word);
		// Calculate Elapsed / Execute Time
		long startTimeRemove = System.nanoTime();
		trie.remove(word);
		System.out.println("Number Of Words: " + trie.getNumberOfWords());
		long stopTimeRemove = System.nanoTime();
		double elapsedTimeRemove = (stopTimeRemove - startTimeRemove)/1e6;;
		System.out.println("Elapsed / Execute Time");
		System.out.println("Elapsed Time in milliseconds: " + elapsedTimeRemove);
		System.out.println("Elapsed Time in seconds: " + (elapsedTimeRemove / 1000.0) % 60.0);
		System.out.println("Elapsed Time in minutes: " + ((elapsedTimeRemove / (1000.0 * 60.0)) % 60.0));
		System.out.println("Elapsed Time in hours: " + ((elapsedTimeRemove / (1000.0 * 60.0 * 60.0)) % 24.0));

	}
}
