// Validation it Validates the input on the program
package Healthcare;
import java.util.Scanner;

public class Validation {
    
    private final Scanner scanner;

    public Validation(Scanner scanner) {
        this.scanner = scanner;
    }

    public String valString(String string) {
        while (true) {
            System.out.print(string);
            String input = scanner.nextLine();
            if (input.trim().length() > 0) {
                return input;
            } else {
                System.out.println("\nERR0R! Invalid Input\n");
            }
        }
    }

    public String valString(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.trim().length() > 0) {
                return input;
            } else {
                System.out.println("\nERR0R! Invalid Input\n");
            }
        }
    }

    public int valInt(Scanner scanner2, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner2.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.print("\nERR0R! Invalid Input, Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("\nERR0R! Invalid Input, Please enter a number between " + min + " and " + max + ": ");
            }
        }
    }

    public String valYesNo(String string) {
        while (true) {
            System.out.print(string);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("no")) {
                return input;
            } else {
                System.out.println("\nERR0R! Invalid Input, Please enter [Yes/No]");
            }
        }
    }

    public String valYesNo(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("no")) {
                return input;
            } else {
                System.out.println("\nERR0R! Invalid Input, Please enter [Yes/No]");
            }
        }
    }
}