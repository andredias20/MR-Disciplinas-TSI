package calculadora.main;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticProgression {
	private final int firstTerm;
	private final int commonDiference;

	public ArithmeticProgression(int firstTerm, int commonDiference) {
		this.firstTerm = firstTerm;
		this.commonDiference = commonDiference;
	}

	public int termOfIndex(int index) {
		return firstTerm + (index-1) * commonDiference;
	}

	public int progressionSum(int quantityOfTerms) {
		return (quantityOfTerms*(firstTerm+ this.termOfIndex(quantityOfTerms))/2);
	}

	public List<Integer> getAllTerms(int quantityOfTerms)
	{
		List<Integer> listAllTerms = new ArrayList<>();
		for (int index = 1; index <= quantityOfTerms; index++) {
			listAllTerms.add(
				termOfIndex(index)
			);
		}
		return listAllTerms;
	}
}
