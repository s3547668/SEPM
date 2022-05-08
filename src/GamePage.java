import java.util.Scanner;

public class GamePage {
    Scanner userInput = new Scanner(System.in);

    public GamePage() {
        System.out.println("Welcome to Wordle Game");
        System.out.println("Select an option: ");
        System.out.println("Rules");
        String option = userInput.nextLine();

        if (option.equals("Rules")) {
            GameRule.displayRules();
            System.out.println("Would you like to exit the rules page? (y/n)");
            String exit = userInput.nextLine();
            if (exit.equals("y")) {
                System.exit(0);
            }
        }
    }
}
