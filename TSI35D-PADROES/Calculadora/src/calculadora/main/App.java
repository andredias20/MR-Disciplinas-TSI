package calculadora.main;

import java.util.List;

public class App {

    public void go() {

        UserInterface userInterface = new UserInterface();

        int quantityOfTerms = userInterface.readQuantityOfTerms();
		int firstTerm = userInterface.readFirstTerm();
		int commonDifference = userInterface.readCommonDifference();


        ArithmeticProgression arithmeticProgression = new ArithmeticProgression(firstTerm, commonDifference);

        int progressionSum = arithmeticProgression.progressionSum(quantityOfTerms);
        userInterface.printProgressionSum(progressionSum);


        List<Integer> allTerms = arithmeticProgression.getAllTerms(quantityOfTerms);
        userInterface.printAllTerms(allTerms);
        
    }

    public static void main(String[] args) {
        App app = new App();
        app.go();
    }

}