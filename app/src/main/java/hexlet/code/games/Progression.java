package hexlet.code.games;
import hexlet.code.Engine;

@SuppressWarnings("checkstyle:Indentation")
public class Progression {

    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int PROGRESSION_LENGTH = 10;
    private static final int OPERATIONS_COUNT = 3;

    public static void play() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {

            int[] progression = generateProgression(PROGRESSION_LENGTH);
            int hiddenIndex = Engine.getRandomNumber(1, 9);
            String question = formatQuestion(progression, hiddenIndex);
            String correctAnswer = String.valueOf(progression[hiddenIndex]);
            questionsAndAnswers[i] = new String[] {
                    question,
                    correctAnswer
            };
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }

    @SuppressWarnings("checkstyle:WhitespaceAround")
    public static int[] generateProgression(int length) {
        int startNumber = Engine.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        int[] progression = new int[PROGRESSION_LENGTH];
        int step = Engine.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        progression[0] = startNumber;
        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;

    }

    public static String formatQuestion(int[] progression, int hiddenIndex) {
        StringBuilder questionBuilder = new StringBuilder();
        for (int i = 0; i < progression.length - 1; i++) {
            if (i == hiddenIndex) {
                questionBuilder.append(".. ");
            } else {
                questionBuilder.append(progression[i]).append(" ");
            }
        }
        return questionBuilder.toString().trim();
    }
}

