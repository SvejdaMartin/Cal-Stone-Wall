import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * Stone Wall Calculator
         * Conzole app for a rough calculation ot the prices and consumption of material for the construction of a stone wall
         */

        Scanner scanner = new Scanner(System.in);
        // Create a project and calculate cost
        Project project = new Project(scanner);
        project.calculateTotalProjectCost();
        scanner.close();
    }
}
