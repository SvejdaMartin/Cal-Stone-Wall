import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * Stone Wall Calculator
         * Conzole app for a rough calculation ot the prices and consumption of material for the construction of a stone wall
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Foundation Calculator");

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
        System.out.println();
        System.out.println("Stone Wall Calculator");
        System.out.print("Enter wall width (m): ");
        double wallWidth = scanner.nextDouble();
        System.out.print("Enter wall length (m): ");
        double wallLength = scanner.nextDouble();
        System.out.print("Enter wall height (m): ");
        double wallHeight = scanner.nextDouble();
        System.out.print("Will the wall use only stones or a combination of stones and lost shuttering (true for combination, false for only stones)? ");
        boolean useLostShuttering = scanner.nextBoolean();

        double stonePrice = 0, shutteringPrice = 0;
        if(useLostShuttering){
            System.out.print("Enter price per ton of stone: ");
            stonePrice = scanner.nextDouble();
            System.out.print("Enter price per piece of lost shuttering: ");
            shutteringPrice = scanner.nextDouble();
        } else {
            System.out.print("Enter price per ton of stone: ");
            stonePrice = scanner.nextDouble();
        }
        Wall wall = new Wall(wallWidth, wallLength, wallHeight, useLostShuttering, stonePrice, shutteringPrice);

        double totalWallCost = wall.calculateTotalCost();
        System.out.printf("Total wall cost: %.2f\n", totalWallCost);
        scanner.close();


    }
}
