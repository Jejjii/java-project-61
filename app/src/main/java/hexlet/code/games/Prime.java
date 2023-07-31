package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class Prime {
    public static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;
    private static final int OPERATIONS_COUNT = 3;

    public static void play() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int anyNumber = Utils.getRandomNumber(MIN_NUMBER,MAX_NUMBER);
            String question = String.valueOf(anyNumber);
            String correctAnswer = checkPrime(anyNumber) ? "yes" : "no";
            questionsAndAnswers[i] = new String[]{question, correctAnswer};
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }

    public static boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
