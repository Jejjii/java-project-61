package hexlet.code;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SuppressWarnings({"checkstyle:Indentation", "checkstyle:MissingJavadocType"})
public class App {
    @SuppressWarnings("checkstyle:MissingJavadocMethod")
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
                Engine.sayHello(args);
                break;
            case "2":
                Engine.sayHello(args);
                Engine.playEvenGame();
                break;
            case "3":
                Engine.sayHello(args);
                Engine.playCalcGame();
                break;
            case "4":
                Engine.sayHello(args);
                Engine.playGCDGame();
                break;
            case "5":
                Engine.sayHello(args);
                Engine.playProgressionGame();
                break;
            case "6":
                Engine.sayHello(args);
                Engine.playPrimeGame();
                break;
            case "0":
                // код для выхода из программы
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}


