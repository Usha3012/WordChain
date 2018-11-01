package org.algo.wordchain.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.algo.wordchain.domain.Dictionary;
import org.algo.wordchain.domain.WordGroup;

public class WordChainSolver {
    
	public List<String> solve(String startWord, String targetWord) {
		if (startWord.equalsIgnoreCase(targetWord)) {
			
			return Arrays.asList(startWord);
		}

		if (startWord.length() != targetWord.length()) {
			return Collections.EMPTY_LIST;
		}

		Queue<WordGroup> wordQueue = new LinkedList<WordGroup>();
		List<String> wordListInGroup = new LinkedList<>();
		wordListInGroup.add(startWord);
		WordGroup firstWordGroup = new WordGroup(wordListInGroup, 1);
		wordQueue.add(firstWordGroup);
		List<String> visited = new ArrayList<String>();
		visited.add(startWord.toLowerCase());
		while (!wordQueue.isEmpty()) {
			WordGroup currentWordGroup = wordQueue.remove();
			String currentWord = currentWordGroup.lastAddedWord();
			if (currentWord.equalsIgnoreCase(targetWord)) {
				return currentWordGroup.getGroup();
			}
			List<String> neighborWords = Dictionary.INSTANCE
					.getWordOfSize(currentWord.length());
			for (String neighborWord : neighborWords) {
				if (isSingleWordDistanced(currentWord.toLowerCase(),
						neighborWord.toLowerCase())
						&& !visited.contains(neighborWord.toLowerCase())) {
					List<String> newGroup = new LinkedList<>(
							currentWordGroup.getGroup());
					newGroup.add(neighborWord);
					visited.add(neighborWord.toLowerCase());
					WordGroup newWordGroup = new WordGroup(newGroup,
							newGroup.size());
					wordQueue.add(newWordGroup);
				}
			}
		}
		return Collections.EMPTY_LIST;
	}


	private boolean isSingleWordDistanced(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count++;
			}
		}
		return count == 1;
	}

}
