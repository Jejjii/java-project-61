package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class Even {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int ROUNDS_COUNT = 3;
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play() {
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            String question = String.valueOf(number);
            String correctAnswer = isEven(number) ? "yes" : "no";
            questionsAndAnswers[i] = new String[]{question, correctAnswer};
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

