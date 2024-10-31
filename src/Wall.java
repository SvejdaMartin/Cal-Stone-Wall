public class Wall {
    /**
     * The class represents a stone wall. Methods are used for calculation whole price.
     *
     */
    private double width, length, height;
    private boolean useLostShuttering;
    private double stonePricePerTon;

    public Wall(double width, double length, double height, boolean useLostShuttering, double stonePricePerTon, double shutteringPricePerPiece ){
        this.width = width;
        this.length = length;
        this.height = height;
        this.useLostShuttering = useLostShuttering;
        this.stonePricePerTon = stonePricePerTon;
    }
    public double calculateStoneVolume(){
        return width * length * height;
    }
    public double calculateStoneCost(){
        return calculateStoneVolume() * 2.6 * stonePricePerTon; //  1m3 = 2,6 tons of stones
    }
    public double calculateTotalCost() {
        double totalCost = calculateStoneCost();
        if (useLostShuttering) {
            totalCost += calculateStoneCost();
        }
        return totalCost;
    }
}
