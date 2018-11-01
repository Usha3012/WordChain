package wordchain;

import org.algo.wordchain.Game;
import org.junit.Test;

public class GameTest {

	@Test
	public void testGamePositive(){
		String testFileName="test-words.txt";
		Game game=new Game();
		game.start(testFileName);
	}
}
