package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.util.Utils;


public class Calc {

    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;
    private static final int OPERATIONS_COUNT = 3;


    public static void play() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int firstOperand = Utils.getRandomNumber(MIN_NUMBER,MAX_NUMBER);
            int secondOperand = Utils.getRandomNumber(MIN_NUMBER,MAX_NUMBER);
            int operationIndex = Utils.getRandomNumber(0,OPERATIONS_COUNT - 1);
            int correctAnswer = calc(firstOperand, secondOperand, operationIndex);
            String question = String.format("%d %s %d",
                    firstOperand, getOperationSymbol(operationIndex), secondOperand);
            questionsAndAnswers[i] = new String[] {question, String.valueOf(correctAnswer)
            };
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }

    private static String getOperationSymbol(int index) {
        switch (index) {
            case 0:
                return "+";
            case 1:
                return "-";
            default:
                return "*";
        }
    }

    public static int calc(int firstOperand, int secondOperand, int operationIndex) {
        switch (operationIndex) {
            case 0:
                return firstOperand + secondOperand;
            case 1:
                return firstOperand - secondOperand;
            default:
                return firstOperand * secondOperand;
        }

    }
}
