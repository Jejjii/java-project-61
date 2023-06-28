package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_START_NUMBER = 1;
    private static final int MAX_START_NUMBER = 50;
    private static final int MIN_STEP = 2;
    private static final int MAX_STEP = 10;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    public static void play() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int startNumber = Engine.getRandomNumber(MIN_START_NUMBER, MAX_START_NUMBER);
            int step = Engine.getRandomNumber(MIN_STEP, MAX_STEP);
            int length = Engine.getRandomNumber(MIN_LENGTH, MAX_LENGTH);
            String progression = generateProgression(startNumber, step, length);
            int missingIndex = Engine.getRandomNumber(0, length - 1);
            String correctAnswer = String.valueOf(startNumber + (step * missingIndex));
            String question = replaceNumberWithDots(progression, missingIndex);
            questionsAndAnswers[i] = new String[]{question, correctAnswer};
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }

    public static String generateProgression(int startNumber, int step, int length) {
        StringBuilder progression = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int currentNumber = startNumber + (step * i);
            progression.append(currentNumber).append(" ");
        }
        return progression.toString().trim();
    }

    public static String replaceNumberWithDots(String progression, int index) {
        String[] numbers = progression.split(" ");
        numbers[index] = "..";
        return String.join(" ", numbers);
    }
}
