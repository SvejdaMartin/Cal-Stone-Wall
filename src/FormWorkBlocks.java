public class FormWorkBlocks {
    /**
     * The class represents form work blocks Which are sometimes used for building a stone wall.
     * Those blocks are inside the stone wall, building is easier and faster with them, you will not need to manipulate with big stones.
     * Methods are used for calculation whole price and amount which you need to order.
     */
    private double length, height;
    private double blockPricePerPiece;

    public FormWorkBlocks(double length, double height, double blockPricePerPiece){
        this.length = length;
        this.height = height;
        this.blockPricePerPiece = blockPricePerPiece;
    }
    // Calculation of Formwork Blocks with dimensions l = 0.5m, h = 0.25m, w = 0.1m. 8 pieces is needed for 1 m2
    public int calculateFormBlockCount(){
        return (int) Math.ceil(height) * (int) Math.ceil(length) * 8;
    }
    // Calculation of Formwork Block cost
    public double calculateFormBlockCost(){
        return calculateFormBlockCount() * blockPricePerPiece;
    }
}
