package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.util.Utils;


public class Calc {

    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void play() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int firstOperand = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int secondOperand = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int operationIndex = Utils.getRandomNumber(0, Engine.ROUNDS_COUNT - 1);
            int correctAnswer = calc(firstOperand, secondOperand, operationIndex);
            String question = String.format("%d %s %d",
                    firstOperand, OPERATIONS[operationIndex], secondOperand);
            questionsAndAnswers[i] = new String[]{question, String.valueOf(correctAnswer)};
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }

    public static int calc(int firstOperand, int secondOperand, int operationIndex) {
        switch (OPERATIONS[operationIndex]) {
            case "+" -> {
                return firstOperand + secondOperand;
            }
            case "-" -> {
                return firstOperand - secondOperand;
            }
            case "*" -> {
                return firstOperand * secondOperand;
            }
            default -> throw new IllegalArgumentException("Invalid operation: " + OPERATIONS[operationIndex]);
        }
    }

}
