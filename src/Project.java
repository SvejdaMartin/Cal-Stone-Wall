import java.util.Scanner;

public class Project {
    /**
     * Controller class for calculations and inputs.
     */
    private Foundation foundation;
    private Wall wall;
    private FormWorkBlocks blocks;

    public Project(Scanner scanner) {
        // Inputs for a foundation
        System.out.println("-------------- Foundation Calculator --------------");
        double foundationWidth = InputValidator.getPositiveDouble(scanner, "Enter foundation width (m): ");
        double foundationLength = InputValidator.getPositiveDouble(scanner, "Enter foundation length (m): ");
        double foundationDepth = InputValidator.getPositiveDouble(scanner, "Enter foundation depth (m): ");
        double concretePrice = InputValidator.getPositiveDouble(scanner, "Enter the price per cubic meter of concrete: ");
        double rebarPrice = InputValidator.getPositiveDouble(scanner, "Enter the price per meter of the steel bar: ");
        this.foundation = new Foundation(foundationWidth, foundationLength, foundationDepth, concretePrice, rebarPrice);

        // Inputs for a wall
        System.out.println("-------------- Stone Wall Calculator --------------");
        double wallWidth = InputValidator.getPositiveDouble(scanner, "Enter wall width (m): ");
        double wallLength = InputValidator.getPositiveDouble(scanner, "Enter wall length (m): ");
        double wallHeight = InputValidator.getPositiveDouble(scanner, "Enter wall height (m): ");
        boolean useFormWorkBlocks = InputValidator.getBoolean(scanner, "Select construction method (true = Stone with formwork block, false = Stone only): ");
        double stonePrice = InputValidator.getPositiveDouble(scanner, "Enter price per ton of stone: ");
        this.wall = new Wall(wallWidth, wallLength, wallHeight, useFormWorkBlocks, stonePrice);

        // Formwork blocks option
        if (useFormWorkBlocks) {
            double blockPrice = InputValidator.getPositiveDouble(scanner, "Enter price per piece of formwork block: ");
            this.blocks = new FormWorkBlocks(wallLength, wallHeight, blockPrice);
        }
    }

    public void calculateTotalProjectCost() {
        System.out.println("\n--- Total Project Cost ---\n");

        // Foundation cost calculation
        double concreteCost = foundation.calculateConcreteCost();
        double rebarCost = foundation.calculateRebarCost();
        double foundationTotalCost = foundation.calculateTotalFoundationPrice();
        System.out.printf("Foundation - Concrete cost: %.2f, Rebar cost: %.2f, Total foundation cost: %.2f\n", concreteCost, rebarCost, foundationTotalCost);

        // Wall cost calculation
        double wallCost;
        if (wall.isUseFormWorkBlocks()) {
            wallCost = wall.calculateCombStoneCost() + blocks.calculateFormBlockCost();
            System.out.printf("Wall (Stone + Formwork Block) - Total cost: %.2f\n", wallCost);
            System.out.printf("Materials needed: %.2f tons of stone, %d pieces of formwork blocks\n", wall.calculateCombVolume() * 2.6, blocks.calculateFormBlockCount());
        } else {
            wallCost = wall.calculateStoneCost();
            System.out.printf("Wall (Stone only) - Total cost: %.2f\n", wallCost);
            System.out.printf("Materials needed: %.2f tons of stone\n", wall.calculateStoneVolume() * 2.6);
        }
        // Total cost of the project
        double totalProjectCost = foundationTotalCost + wallCost;
        System.out.printf("\nTotal project cost: %.2f\n", totalProjectCost);
    }
}
