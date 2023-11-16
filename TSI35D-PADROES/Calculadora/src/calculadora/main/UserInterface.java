package calculadora.main;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

	private final PrintStream printStream;
	private final Scanner scanner;

	public UserInterface() {
		printStream = System.out;
		scanner = new Scanner(System.in);
	}

	private int readIntegerValue(String messageAsked, int minimalValue) {
		int userValue;
		do {
			printStream.println(messageAsked);
			userValue = scanner.nextInt();
		} while (userValue < minimalValue);
		return userValue;
	}

	public int readCommonDifference() {
		return readIntegerValue("Digite a razão da PA: ", 1);
	}

	public int readQuantityOfTerms() {
		return readIntegerValue("Digite a quantidade de termos da PA: ", 2);
	}

	public int readFirstTerm() {
		return readIntegerValue("Digite o termo inicial da PA: ", 1);
	}

	public void printAllTerms(List<Integer> listOfTerms){
		System.out.println("Lista de termos: \n");
		for (int index = 0; index < listOfTerms.size(); index++) {
			printTerm(index ,listOfTerms.get(index));
		}
	}

	public void printProgressionSum(Integer term){
		System.out.printf("A soma dos termos é %d" , term);
		System.out.println("\n\n");
	}

	public void printTerm(Integer position, Integer term){
		System.out.printf(" %dº termo: %d \n", position+1 , term );
	}


}
