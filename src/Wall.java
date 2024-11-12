public class Wall {
    /**
     * The class represents a stone wall. Methods are used for calculation whole price.
     */
    private double width, length, height;
    private boolean useFormWorkBlocks;
    private double stonePricePerTon;
    public static final double STONE_DENSITY = 2.6; // Density of the stone for calculation (m3,tons)

    public Wall(double width, double length, double height, boolean useFormWorkBlocks, double stonePricePerTon){
        this.width = width;
        this.length = length;
        this.height = height;
        this.useFormWorkBlocks = useFormWorkBlocks;
        this.stonePricePerTon = stonePricePerTon;
    }
    // Calculation of Stone Volume
    public double calculateStoneVolume(){
        return width * length * height;
    }
    // Calculation of Stone Cost, 1m3 = 2.6 tons of stones
    public double calculateStoneCost(){
        return calculateStoneVolume() * STONE_DENSITY * stonePricePerTon;
    }
    // Calculation of Stone Volume for Wall with Form Work Blocks, width of the block is 0.1m
    public double calculateCombVolume(){
        double combWidth = width - 0.1;
        return combWidth * length * height;
    }
    //Calculation of Combi Stone Cost, 1 m3 = 2.6 tons of stones
    public double calculateCombStoneCost(){
        return calculateCombVolume() * STONE_DENSITY * stonePricePerTon;
    }
    // Getter for useFormWorkBlocks in Project class
    public boolean isUseFormWorkBlocks() {
        return useFormWorkBlocks;
    }
}
