import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * Stone Wall Calculator
         * Conzole app for a rough calculation ot the prices and consumption of material for the construction of a stone wall
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------- Foundation Calculator --------------");
        System.out.println();
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
        System.out.println();
        System.out.println("-------------- Stone Wall Calculator --------------");
        System.out.println();
        System.out.print("Enter wall width (m): ");
        double wallWidth = scanner.nextDouble();
        System.out.print("Enter wall length (m): ");
        double wallLength = scanner.nextDouble();
        System.out.print("Enter wall height (m): ");
        double wallHeight = scanner.nextDouble();
        System.out.print("Select construction method (true = Stone with formwork block, false = Stone only): ");
        boolean useFormWorkBlocks = scanner.nextBoolean();

        System.out.print("Enter price per ton of stone: ");
        double stonePrice = scanner.nextDouble();
        Wall wall = new Wall(wallWidth, wallLength, wallHeight, useFormWorkBlocks, stonePrice);

        if(useFormWorkBlocks){
            System.out.print("Enter price per piece of formwork block (dimension of one block: l = 0.5m, h = 0.25m, w = 0.1m): ");
            double blockPrice = scanner.nextDouble();
            FormWorkBlocks blocks = new FormWorkBlocks(wallLength,wallHeight,blockPrice);
            double totalWallCost = wall.calculateCombStoneCost() + blocks.calculateFormBlockCost();
            System.out.printf("Total wall cost is %.2f\n", totalWallCost);
            System.out.printf("You need to order : %.2f tons of stones at a price of %.2f and %d pieces of formwork blocks at a price of %.2f\n", wall.calculateCombVolume()*2.6, wall.calculateCombStoneCost(), blocks.calculateFormBlockCount(), blocks.calculateFormBlockCost());
        } else {
            System.out.printf("Total wall cost is %.2f you will need to order %.2f tons of stones.\n", wall.calculateStoneCost(), wall.calculateStoneVolume()*2.6);
        }
        scanner.close();
    }
}
