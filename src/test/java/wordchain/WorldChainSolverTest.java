package wordchain;

import static org.junit.Assert.*;

import java.util.List;

import org.algo.wordchain.solver.WordChainSolver;
import org.junit.Test;

public class WorldChainSolverTest {

	@Test
	public void test() {
		WordChainSolver solver=new WordChainSolver();
		List<String> case1=solver.solve("CAT", "DOG");
		List<String> case2=solver.solve("DOG", "CAT");
		assertTrue(!case1.isEmpty());
		assertTrue(!case2.isEmpty());
	
	}

}
