package org.algo.wordchain.domain;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.algo.wordchain.util.ConsoleOutputPrinter;
import org.algo.wordchain.util.FileUtil;

public class Dictionary {
	public static final Dictionary INSTANCE = new Dictionary();
	private Map<Integer, List<String>> internalStorage = new HashMap<>();

	private Dictionary() {
		try {
			loadDictionary();
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
			ConsoleOutputPrinter.print("Issue loading dictionary");
		}
	}

	public void loadDictionary() throws URISyntaxException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream file = classLoader.getResourceAsStream("wordlist.txt");
		List<String> words = FileUtil.readFile(file);
		for (String word : words) {
			List<String> wordPartition = internalStorage.get(word.length());
			if (wordPartition != null) {
				wordPartition.add(word);
			} else {
				wordPartition = new ArrayList<>();
				wordPartition.add(word);
				internalStorage.put(word.length(), wordPartition);
			}
		}
	}
	
	public List<String> getWordOfSize(int size){
		return internalStorage.getOrDefault(size, Collections.EMPTY_LIST);
	}

	}
