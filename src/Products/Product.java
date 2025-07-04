package Products;

public abstract class Product {
    final protected String name;
    final private double price;
    static int counter = 0;
    private int quantity = 0;
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        ++counter;
    }
    public boolean isAvailable(int required) {
        return quantity >= required;
    }
    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }
    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

}
