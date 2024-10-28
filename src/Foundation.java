public class Foundation {
    /**
     * Foundation for the stone wall
     * Contains methods for calculation of the concrete volume and amount of steel bars
     * Prices of the concrete and bars will be calculated based on the prices entered by the user
     */
    private double width, length, depth, concretePrice, rebarPrice;

    public Foundation(double width, double length, double depth, double concretePrice, double rebarPrice ){
        this.width = width;
        this.length = length;
        this.depth = depth;
        this.concretePrice = concretePrice;
        this.rebarPrice = rebarPrice;
    }
    // Method for calculation of volume of the concrete for foundation
    public double calculateConcreteVolume(){
        return width * length * depth;
    }
    // Method for calculation of the price for the concrete in foundation, concrete price is for 1m3 of the concrete
    public double calculateConcreteCost(){
        return calculateConcreteVolume() * concretePrice;
    }
    // Calculation of amount of steel bars, vertically embedded in poured concrete ( length 1m )
    public int calculateRebarCount(){
        return (int)  Math.ceil(length/0.5);
    }
    // Calculation of the price of steel bars, rebarPrice is for 1m of a steel bar.
    public double calculateRebarCost(){
        return calculateRebarCount() * rebarPrice;
    }
    // Calculation of the price of all materials used for foundation
    public double calculateTotalFoundationPrice(){
        return calculateConcreteCost() + calculateRebarCost();
    }
}
