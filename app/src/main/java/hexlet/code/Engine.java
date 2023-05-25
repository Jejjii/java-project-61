package hexlet.code;
import java.util.Scanner;
import java.util.Random;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

@SuppressWarnings({
        "checkstyle:Indentation",
        "checkstyle:NoWhitespaceBefore",
        "checkstyle:MissingJavadocType",
        "checkstyle:LineLength"
})
public class Engine {
    public static final int ROUNDS_COUNT = 3;
    private static final Scanner scannerInput = new Scanner(System.in);
    private static final Random randomGenerator = new Random();

    public static int getRandomNumber(int min, int max) {

        return randomGenerator.nextInt(max - min + 1) + min;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public static void play(String gameDescription, String[][] questionsAndAnswers) {
        System.out.println(gameDescription);
        int correctAnswersCount = 0;
        for (String[] questionAndAnswer: questionsAndAnswers) {
            String question = questionAndAnswer[0];
            String correctAnswer = questionAndAnswer[1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scannerInput.nextLine();

            if (checkAnswer(userAnswer, correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.printf("Wrong! Correct answer is %s.\n", correctAnswer);
            }
        }
        System.out.printf("You answered %d out of %d questions correctly.\n", correctAnswersCount, ROUNDS_COUNT);
    }

    public static void playEvenGame() {
        Even.play();
    }
    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void playCalcGame() {
        Calc.play();
    }
    public static void playGCDGame() {
        GCD.play();
    }
    public static void playPrimeGame() {
        Prime.play();
    }

    public static void playProgressionGame() {
        Progression.play();
    }


    public static void sayHello(String[] args) {
        Scanner scannerHello = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = scannerHello.next();
        System.out.println("Hello, " + name + "!");
    }

}

