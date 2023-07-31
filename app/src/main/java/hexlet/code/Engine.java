package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class Engine {
    public static final int ROUNDS_COUNT = 3;
    private static final Scanner SCANNER_INPUT = new Scanner(System.in);
    private static String name;
    public static boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    public static void play(String gameDescription, String[][] questionsAndAnswers) {
        System.out.println(gameDescription);
        int correctAnswersCount = 0;
        for (String[] questionAndAnswer: questionsAndAnswers) {
            String question = questionAndAnswer[0];
            String correctAnswer = questionAndAnswer[1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = SCANNER_INPUT.nextLine();

            if (checkAnswer(userAnswer, correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer);
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");

    }

    public static void playEvenGame() {
        Even.play();
    }

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
        System.out.print("May I have your name? ");
        name = scannerHello.next();
        System.out.println("Hello, " + name + "!");
    }
}
