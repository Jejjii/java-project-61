package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

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
            int startNumber = Utils.getRandomNumber(MIN_START_NUMBER, MAX_START_NUMBER);
            int step = Utils.getRandomNumber(MIN_STEP, MAX_STEP);
            int length = Utils.getRandomNumber(MIN_LENGTH, MAX_LENGTH);
            String[] progression = generateProgressionArray(startNumber, step, length);
            int missingIndex = Utils.getRandomNumber(0, length - 1);
            String correctAnswer = progression[missingIndex];
            progression[missingIndex] = "..";
            String question = String.join(" ", progression);
            questionsAndAnswers[i] = new String[]{question, correctAnswer};
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }

    public static String[] generateProgressionArray(int startNumber, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(startNumber + (step * i));
        }
        return progression;
    }
}
