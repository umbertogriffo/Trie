package Algo.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

import Algo.tries.Trie;

public class Performance {
	public static void main(String[] args) {

		File fileName = new File("Input/testCase2");
		
		/**
		 * GENERATE TRIE
		 */
		// Calculate Elapsed / Execute Time
		long startTime = System.currentTimeMillis();
		// this is a case sensitive trie
		Trie trie = new Trie(true,StandardCharsets.UTF_8);
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			br.readLine();
			for (String line; (line = br.readLine()) != null;) {
				//System.out.println(line);
				String[] in = line.split(" ");
				String op = in[0];
				String contact = in[1];
				if (op.equals("add")) {
					trie.add(contact);
				}
			}

			System.out.println("Number Of Words: "+trie.getNumberOfWords());
			
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
			// Calculate Elapsed / Execute Time
			long startTimeGetCountWordStartsWith = System.currentTimeMillis();			
			System.out.println("Number Of Words Starts with 'y': "+trie.countWordStartsWith("y"));
			
			long stopTimeGetCountWordStartsWith = System.currentTimeMillis();
			long elapsedTimeGetCountWordStartsWith = stopTimeGetCountWordStartsWith - startTimeGetCountWordStartsWith;
			System.out.println("Elapsed / Execute Time");
			System.out.println("Elapsed Time in milliseconds: " + elapsedTimeGetCountWordStartsWith);
			System.out.println("Elapsed Time in seconds: " + (elapsedTimeGetCountWordStartsWith / 1000) % 60);
			System.out.println("Elapsed Time in minutes: " + ((elapsedTimeGetCountWordStartsWith / (1000 * 60)) % 60));
			System.out.println("Elapsed Time in hours: " + ((elapsedTimeGetCountWordStartsWith / (1000 * 60 * 60)) % 24));

			/**
			 * Get Words Starts With
			 */
			// Calculate Elapsed / Execute Time
			long startTimeGetWordStartsWith = System.currentTimeMillis();
			trie.getWordStartsWith("y").collect(Collectors.toList());					
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
			// Calculate Elapsed / Execute Time
			long startTimeGetWordStartsWithJava7 = System.currentTimeMillis();
			trie.getWordStartsWithJava7("y");			
			long stopTimeGetWordStartsWithJava7 = System.currentTimeMillis();
			long elapsedTimeGetWordStartsWithJava7 = stopTimeGetWordStartsWithJava7 - startTimeGetWordStartsWithJava7;
			System.out.println("Elapsed / Execute Time");
			System.out.println("Elapsed Time in milliseconds: " + elapsedTimeGetWordStartsWithJava7);
			System.out.println("Elapsed Time in seconds: " + (elapsedTimeGetWordStartsWithJava7 / 1000) % 60);
			System.out.println("Elapsed Time in minutes: " + ((elapsedTimeGetWordStartsWithJava7 / (1000 * 60)) % 60));
			System.out.println("Elapsed Time in hours: " + ((elapsedTimeGetWordStartsWithJava7 / (1000 * 60 * 60)) % 24));
			
			/**
			 * Similarity
			 */
			// Calculate Elapsed / Execute Time
			long startTimeSimilarity = System.currentTimeMillis();
			for (Map.Entry<String, Integer> entry : trie.similarity("yxxacpbdttrtxevzgjfg", 10).entrySet()) {
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}			
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
			// Calculate Elapsed / Execute Time
			long startTimeRemove = System.currentTimeMillis();
			trie.remove("yxxacpbdttrtxevzgjfg");			
			System.out.println("Number Of Words: "+trie.getNumberOfWords());
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
	}}
