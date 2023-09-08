class Product {
    private final String productName, category;
    private final double price;

    public Product(String productName, double price, String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product Name: " + productName + "\nPrice: " + price + "\nCategory: " + category;
    }
}

class ElectronicProduct extends Product {
    String[] features;

    public ElectronicProduct(String productName, double price, String category, String[] features) {
        super(productName, price, category);
        this.features = features;
    }

    public void displayFeatures() {
        System.out.println("Features:");
        for (String feature : features) {
            System.out.println(feature);
        }
    }
}

class Program1 {
  public static void main(String[] args) {
    String[] features = {"Battery", "Screen", "Camera"};
    ElectronicProduct product = new ElectronicProduct("iPhone", 100000.0, "Phones", features);
    System.out.println(product);
    product.displayFeatures();
    
  }
}
