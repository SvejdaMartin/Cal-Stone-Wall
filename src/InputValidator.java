import java.util.Scanner;

public class InputValidator {
    /**
     * The class contains user input validation methods.
     */
    // Validation of a positive number for a double type
    public static double getPositiveDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) {
                    break; // valid input
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // skip non valid input
            }
        }
        return value;
    }
    // Validation of boolean input
    public static boolean getBoolean(Scanner scanner, String prompt){
        boolean rightBoolean;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextBoolean()){
                rightBoolean = scanner.nextBoolean();
                break; // end while cycle when read valid value
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
                scanner.next(); // skip non valid input
            }
        }
        return rightBoolean;
    }
}
