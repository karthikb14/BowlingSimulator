import java.util.Scanner;

public class PlayerConsole {

    private static PlayerConsole console;
    private Scanner scanner = new Scanner(System.in);
    private PlayerConsole() {

    }

    public static PlayerConsole getInstance() {
        if (console == null) {
            console = new PlayerConsole();
        }
        return console;
    }

    public int getPinsDown() {
        int input = scanner.nextInt();
        while (input < 0 || input > 10) {
            System.out.println("Invalid input. Please try again..");
            input = scanner.nextInt();
        }

        return input;
    }
}
