package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Engine.name = name;
    }

    public static void play(String gameDescription, String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);
        Cli.greet();
        System.out.println(gameDescription);
        for (String[] questionAndAnswer : questionsAndAnswers) {
            String question = questionAndAnswer[0];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(questionAndAnswer[1])) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                        userAnswer, questionAndAnswer[1]);
                System.out.println("Let's try again, " + Engine.getName() + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + Engine.getName() + "!");
    }
}
