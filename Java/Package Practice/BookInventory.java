package inventory;


interface Stockable {
    int getStockQuantity();
}

public class BookInventory implements Stockable {
    private int stockQuantity;
    
    public BookInventory(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public int getStockQuantity() {
        return stockQuantity;
    }
}
