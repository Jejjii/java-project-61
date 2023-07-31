package hexlet.code;
import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        String choice = scanner.next();
        System.out.println();

        switch (choice) {
            case "1":
                Cli.greet();
                break;
            case "2":
                runGame(Engine::playEvenGame);
                break;
            case "3":
                runGame(Engine::playCalcGame);
                break;
            case "4":
                runGame(Engine::playGCDGame);
                break;
            case "5":
                runGame(Engine::playProgressionGame);
                break;
            case "6":
                runGame(Engine::playPrimeGame);
                break;
            case "0":
                // код для выхода из программы
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private static void runGame(Runnable game) {
        Engine.sayHello(null); // null, так как args не используются в sayHello
        game.run();
    }
}
