package org.algo.wordchain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.algo.wordchain.solver.WordChainSolver;
import org.algo.wordchain.util.ConsoleOutputPrinter;

public class Game {
	private final WordChainSolver solver = new WordChainSolver();

	public void start(String filename) throws IOException {
		try (Stream<String> line = Files.lines(Paths.get(filename))) {
			line.forEach(wordLine -> findWordChain(wordLine));
		} 
	}

	public void findWordChain(String eachLine) {
		if (eachLine != null && !eachLine.isEmpty()) {
			String[] words = eachLine.split("\\s+");
			if (words.length == 2) {
				List<String> result = solver.solve(words[0], words[1]);
				if (!result.isEmpty()) {
					ConsoleOutputPrinter.print("YES");
					printPath(result);
				} else {
					ConsoleOutputPrinter.print("NO");
				}
			}
		}
	}

	private void printPath(List<String> pathList) {
		String result = String.join("->", pathList);
		ConsoleOutputPrinter.print(result);
	}

}
