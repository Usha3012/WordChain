package org.algo.wordchain;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		if(args.length!=1){
			throw new IllegalArgumentException("Please provide input file");
		}
		String inputFileName=args[0];
		Game game=new Game();
		game.start(inputFileName);
	}
}
