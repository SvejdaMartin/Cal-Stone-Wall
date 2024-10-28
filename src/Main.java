import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * Stone Wall Calculator
         * Conzole app for a rough calculation ot the prices and consumption of material for the construction of a stone wall
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Stone Wall Calculator");

        System.out.print("Enter foundation width (m): ");
        double foundationWidth = scanner.nextDouble();
        System.out.print("Enter foundation length (m): ");
        double foundationLength = scanner.nextDouble();
        System.out.print("Enter foundation depth (m): ");
        double foundationDepth = scanner.nextDouble();
        System.out.print("Enter the price per cubic meter of the concrete: ");
        double concretePrice = scanner.nextDouble();
        System.out.print("Enter the price per meter of the steel bar: ");
        double rebarPrice = scanner.nextDouble();

        Foundation foundation = new Foundation(foundationWidth, foundationLength, foundationDepth, concretePrice, rebarPrice);

        double concreteCost = foundation.calculateConcreteCost();
        double rebarCost = foundation.calculateRebarCost();
        double totalCost = foundation.calculateTotalFoundationPrice();
        System.out.println();
        System.out.printf("Total concrete cost: %.2f\n", concreteCost);
        System.out.printf("Total rebar cost: %.2f\n", rebarCost);
        System.out.println();
        System.out.printf("Total cost for the foundation is %.2f You will need to order %.2f m3 of concrete and %d m of steel bars.\n", totalCost, foundation.calculateConcreteVolume(), foundation.calculateRebarCount());
        System.out.println("Of course you need to add the price of the transport and digger works. ");


    }
}
