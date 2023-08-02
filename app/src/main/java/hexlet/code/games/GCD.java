package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class GCD {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;


    public static void play() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int firstNumber = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int correctAnswer = find(firstNumber, secondNumber);
            String question = String.format("%d %d", firstNumber, secondNumber);
            questionsAndAnswers[i] = new String[]{question, String.valueOf(correctAnswer)};
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }

    public static int find(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }

}
