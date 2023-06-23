package hexlet.code.games;
import hexlet.code.Engine;

@SuppressWarnings({
        "checkstyle:Indentation",
        "checkstyle:MissingJavadocType",
        "checkstyle:LineLength"
})
public class GCD {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;
    private static final int OPERATIONS_COUNT = 3;

    @SuppressWarnings({
            "checkstyle:MissingJavadocMethod",
            "checkstyle:WhitespaceAfter",
            "checkstyle:NoWhitespaceBefore"
    })
    public static void play() {
        String[][] questionsAndAnswers = new String[OPERATIONS_COUNT][2];
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int firstNumber = Engine.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = Engine.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int correctAnswer = find(firstNumber, secondNumber);
            String question = String.format("%d %d", firstNumber, secondNumber);
            questionsAndAnswers[i] = new String[] {
                    question,
                    String.valueOf(correctAnswer)
            };
        }
        Engine.play(GAME_DESCRIPTION, questionsAndAnswers);
    }
    @SuppressWarnings({
            "checkstyle:MethodParamPad",
            "checkstyle:EmptyLineSeparator",
            "checkstyle:MissingJavadocMethod"
    })
    public static int find(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }

}
