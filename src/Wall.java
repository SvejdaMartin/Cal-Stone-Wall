public class Wall {
    /**
     * The class represents a stone wall. Methods are used for calculation whole price.
     *
     */
    private double width, length, height;
    private boolean useLostShuttering;
    private double stonePricePerTon, shutteringPricePerPiece;

    public Wall(double width, double length, double height, boolean useLostShuttering, double stonePricePerTon, double shutteringPricePerPiece ){
        this.width = width;
        this.length = length;
        this.height = height;
        this.useLostShuttering = useLostShuttering;
        this.stonePricePerTon = stonePricePerTon;
        this.shutteringPricePerPiece = shutteringPricePerPiece;
    }
    public double calculateStoneVolume(){
        return width * length * height;
    }
    public double calculateStoneCost(){
        return calculateStoneVolume() * stonePricePerTon; // uprava na m3 dle info je 1m3 = 2 t kamene
    }
    public int calculateShutteringCount(){
        return (int) Math.ceil(height / 0.2) * (int) Math.ceil(length / 1.0); // urcite spatne overit prepocitat na 10tky cihly
    }
    public double calculateTotalCost() {
        double totalCost = calculateStoneCost();
        if (useLostShuttering) {
            totalCost += calculateStoneCost();
        }
        return totalCost;
    }
}
