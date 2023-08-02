package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:
                """);
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {
            case "1" -> Cli.greet();
            case "2" -> Even.play();
            case "3" -> Calc.play();
            case "4" -> GCD.play();
            case "5" -> Progression.play();
            case "6" -> Prime.play();
            case "0" -> {
                // код для выхода из программы
            }
            default -> System.out.println("Invalid choice");
        }
    }

}
